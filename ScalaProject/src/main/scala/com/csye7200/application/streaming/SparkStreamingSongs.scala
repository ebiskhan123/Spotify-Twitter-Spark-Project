package com.csye7200.application.streaming

import org.apache.spark.sql.{Dataset, Row, SparkSession}
import org.apache.spark.sql.functions.{col, explode, from_json}
import org.apache.spark.sql.types.{ArrayType, StringType, StructType}

object SparkStreamingSongs {
  def main(args: Array[String]): Unit = {

    val spark: SparkSession = SparkSession.builder()
      .master("local[3]")
      .appName("SparkStreaming")
      .getOrCreate()

    spark.sparkContext.setLogLevel("ERROR")

    val df = spark.readStream
      .format("kafka")
      .option("kafka.bootstrap.servers", "127.0.0.1:9092")
      .option("subscribe", "songs-topic")
      .option("startingOffsets", "earliest")
      .load()

    val schema = new StructType()
      .add("songDetails",
        ArrayType(new StructType()
          .add("trackName",StringType)
          .add("lyrics",StringType)))
      .add("senderId",StringType)
      .add("tweets",
        ArrayType(new StructType()
          .add("id", StringType)
          .add("text", StringType)))

    val songs = df.selectExpr("cast (value as string)").select(from_json(col("value"),schema).as("data")).select("data.*")
    val songExpanded = songs.select(explode(col("songDetails").as(Seq("trackName", "lyrics"))))

    def saveToFile() = (df : Dataset[Row], batchId: Long) => {
      df.persist()
      df.foreach((row: Row) => {
        // println(SentimentAnalysis.intSentiment(row.toString()))
        val trackName = row.getStruct(0).get(0).toString
        val trackLyrics = SentimentAnalysis.cleanString(row.getStruct(0).get(1).toString)
        val sentiment = SentimentAnalysis.intSentiment(trackLyrics)
        val query = s"INSERT INTO song values('$trackName', '$trackLyrics', '$sentiment')"
        DbWriter.execute(query)
        println(query)
      })
    }

    songExpanded.writeStream
      .outputMode("append")
      .foreachBatch(saveToFile())
      .start()
      .awaitTermination()
  }
}
