package com.csye7200.application.streaming

import org.apache.spark.sql.{DataFrame, DataFrameReader}

import java.sql.{Connection, DriverManager, ResultSet}

object DbOps {
  val url = "jdbc:mysql://localhost:3306/spark?autoReconnect=true"
  val driver = "com.mysql.jdbc.Driver"
  val username = "root"
  val password = ""
  Class.forName(driver)
  var connection:Connection = DriverManager.getConnection(url, username, password)
  val statement = connection.createStatement
  def execute(query: String): Unit = {
    try {
      statement.execute(query)
      //val rs = statement.executeQuery(query)
      //val rs = statement.executeQuery("SELECT * from song")
      //while (rs.next) {
      //  val title = rs.getString("title")
      //  val lyrics = rs.getString("lyrics")
      //  println("title = %s, lyrics = %s".format(title, lyrics))
      //}
    } catch {
      case e: Exception => e.printStackTrace
    }
  }

  def getAllSongs(): List[List[String]] = {
    val query: String = "SELECT * FROM spark.song";
    val rs: ResultSet = statement.executeQuery(query)
    def inner(rs: ResultSet, data: List[List[String]]): List[List[String]] = {
      if (rs.next) inner(rs, data :+ List(rs.getString("title"), rs.getString("lyrics")))
      else data
    }
    inner(rs, List.empty)
  }

  def close() = {
    connection.close
  }
}
