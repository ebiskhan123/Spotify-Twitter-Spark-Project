package com.csye7200.application.streaming

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.catalyst.dsl.expressions.StringToAttributeConversionHelper
import org.apache.spark.sql.{Column, DataFrame, Dataset, ForeachWriter, Row, SparkSession, functions, types}
import org.apache.spark.sql.functions._
import org.apache.spark.sql.functions.struct
import org.apache.spark.sql.types.{ArrayType, StringType, StructField, StructType}

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
      .add("tweets",
        ArrayType(new StructType()
        .add("id", StringType)
        .add("text", StringType)))

    val tweets = df.selectExpr("cast (value as string)").select(from_json(col("value"),schema).as("data")).select("data.*")
    //val tweetExpanded = tweets.select(explode(col("tweets") as "tweets"))

    val tweetExpanded = tweets.select(explode(col("tweets").as(Seq("id", "txt"))))

    def saveToFile(): (Dataset[Row], Long) => Unit = (batchDf : Dataset[Row], batchId: Long) => {
      batchDf.persist()
      //batchDf.printSchema()
      val df = SparkTextCosine.buildFeatureVectorDF(batchDf, List("col.text"))
      df.foreach((row: Row) => {
        /*val tweetId = row.getStruct(0).get(0).toString
        val tweetText = SentimentAnalysis.cleanString(row.getStruct(0).get(1).toString)
        val sentiment = SentimentAnalysis.intSentiment(tweetText)
        val query = s"INSERT INTO tweet values('$tweetId', '$tweetText', '$sentiment')"
        DbWriter.execute(query)
        println(query)*/
        val songDf: DataFrame = getAllSongDf(batchDf.sparkSession)
        df.printSchema()
      })
      df.printSchema()
    }
    tweetExpanded.writeStream
      .outputMode("append")
      .foreachBatch(saveToFile())
      .start()
      .awaitTermination()
  }

  def getAllSongDf(spark: SparkSession): DataFrame = {
    val songList: List[List[String]] = DbOps.getAllSongs()
    val rows = songList.map(x => Row(x: _*))
    val rdd = spark.sparkContext.makeRDD(rows)
    val schema = new StructType()
      .add("trackName",StringType)
      .add("lyrics",StringType)
    spark.sqlContext.createDataFrame(rdd, schema)
  }
}
