package com.csye7200.application.streaming

import org.apache.spark.sql.catalyst.dsl.expressions.StringToAttributeConversionHelper
import org.apache.spark.sql.{Column, SparkSession, functions, types}
import org.apache.spark.sql.functions._
import org.apache.spark.sql.functions.struct
import org.apache.spark.sql.types.{ArrayType, StringType, StructField, StructType}
import org.apache.spark.sql.functions.get_json_object

object SparkStreamingTweets {
  def main(args: Array[String]): Unit = {

    val spark: SparkSession = SparkSession.builder()
      .master("local[3]")
      .appName("SparkStreaming")
      .getOrCreate()

    spark.sparkContext.setLogLevel("ERROR")

    val df = spark.readStream
      .format("kafka")
      .option("kafka.bootstrap.servers", "127.0.0.1:9092")
      .option("subscribe", "tweets-topic")
      .option("startingOffsets", "earliest")
      .load()


    val schema = new StructType()
      .add("songDetails",
        ArrayType(new StructType()
          .add("trackName",StringType)
          .add("lyrics",StringType)))
      .add("senderId",StringType)
      .add("tweets",StringType)

    val songs = df.select(from_json(col("value"),schema))
    val songexpanded = songs.withColumn("songExpanded",explode_outer(col("songDetails")))
    val sentiment = udf(twitterAnalysis.intSentiment _)
    val r = songexpanded.withColumn("songSentiment",sentiment(col("songExpanded.lyrics")))


  }
}
