package com.csye7200.application.streaming

import org.apache.spark.sql.SparkSession

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
  }
}
