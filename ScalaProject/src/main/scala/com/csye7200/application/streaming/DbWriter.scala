package com.csye7200.application.streaming

import java.sql.{Connection, DriverManager}

object DbWriter {
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
  def close() = {
    connection.close
  }
}
