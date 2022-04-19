package com.csye7200.application.streaming

import java.util.Properties
import edu.stanford.nlp.ling.CoreAnnotations
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations
import edu.stanford.nlp.pipeline.{Annotation, StanfordCoreNLP}
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations
import Sentiment.Sentiment
import scala.collection.convert.wrapAll._

object SentimentAnalysis {
    def cleanString(s: String): String = {
        // not including ' and " symbols as they cause issues with DB queries
        s.filter(x => x.toString.matches("[a-z]|[A-Z]|[0-9]|\\ |\\.|\\?|\\!"))
    }

    def main(args: Array[String]): Unit = {
        val input = "Wow u have them trained well "
        val sentiment = mainSentiment(input)
        print(sentiment)
    }

    val props = new Properties()
    props.setProperty("annotators", "tokenize, ssplit, parse, sentiment")
    val pipeline: StanfordCoreNLP = new StanfordCoreNLP(props)

    def intSentiment(input: String): Integer = Option(input) match {
        case Some(text) if !text.isEmpty => extractSentiment(text) match {
            case(Sentiment.NEUTRAL) => 0
            case(Sentiment.POSITIVE) => 1
            case(Sentiment.NEGATIVE) => -1
        }
        case _ => throw new IllegalArgumentException("input can't be null or empty")
    }

    def mainSentiment(input: String): Sentiment = Option(input) match {
        case Some(text) if !text.isEmpty => extractSentiment(text)
        case _ => throw new IllegalArgumentException("input can't be null or empty")
    }

    private def extractSentiment(text: String): Sentiment = {
        val (_, sentiment) = extractSentiments(text)
            .maxBy { case (sentence, _) => sentence.length }
        sentiment
    }

    def extractSentiments(text: String): List[(String, Sentiment)] = {
        val annotation: Annotation = pipeline.process(text)
        val sentences = annotation.get(classOf[CoreAnnotations.SentencesAnnotation])
        sentences
            .map(sentence => (sentence, sentence.get(classOf[SentimentCoreAnnotations.SentimentAnnotatedTree])))
            .map { case (sentence, tree) => (sentence.toString,Sentiment.toSentiment(RNNCoreAnnotations.getPredictedClass(tree))) }
            .toList
    }
}
