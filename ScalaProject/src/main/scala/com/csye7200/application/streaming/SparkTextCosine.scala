package com.csye7200.application.streaming

import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.feature.{HashingTF, IDF, RegexTokenizer, StopWordsRemover}
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions.{col, udf}
import org.apache.spark.ml.linalg.Vector
/*
* https://medium.com/expedia-group-tech/building-large-scale-text-similarity-algorithms-with-spark-ml-pipelines-3dca28828e47
* https://spark.apache.org/docs/latest/ml-pipeline.html
*
* */

object SparkTextCosine {

    def cosineSimilarity = udf((a: Vector, b: Vector) => {
        val l1 = scala.math.sqrt(a.toArray.map(x => x*x).sum)
        val l2 = scala.math.sqrt(b.toArray.map(x => x*x).sum)
        val scalar = a.toArray.zip(b.toArray).map(p => p._1*p._2).sum
        scalar/(l1*l2)
    })

    def cleanString(str: String): String = {
        str.filter(x => x.toString.matches("[a-z]|[A-Z]|[0-9]|\\ |\\.|\\?|\\!"))
            .replaceAll("&#13;"," ")
            .replaceAll("\\.", "\\. ")
            .replaceAll("nbsp", " ")
            .replaceAll("  "," ")
    }

    def buildPipeline(input_df: DataFrame, colNameList: List[String]) = {
        val stringCleaner = udf((s: String) => cleanString(s))
        val columnCleaner = colNameList.map(fld => stringCleaner(col(fld)).as(fld + "_clean"))
        val df = input_df.select(columnCleaner: _*)
        val processingSteps = df.columns.flatMap(colName => {
            val tokenizer = new RegexTokenizer()
                .setInputCol(colName/* + "_clean"*/)
                .setOutputCol(colName + "_tok")
                .setGaps(false)
                .setPattern("\\p{L}+")
            val stopWordsRemover = new StopWordsRemover()
                .setInputCol(colName + "_tok")
                .setOutputCol(colName + "_nostop")
                .setCaseSensitive(false)
            val hashTF = new HashingTF()
                .setInputCol(colName + "_nostop")
                .setOutputCol(colName + "_tf")
                .setNumFeatures(10000)
            val idf = new IDF()
                .setInputCol(colName + "_tf")
                .setOutputCol(colName + "_idf")
            Array(tokenizer, stopWordsRemover, hashTF, idf)
        })
        val pipeline = new Pipeline().setStages(processingSteps)
        pipeline.fit(df).transform(df)
    }

}
