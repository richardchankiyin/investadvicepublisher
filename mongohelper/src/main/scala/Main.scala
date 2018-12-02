package com.richard.mongohelper

object Main {
  def main(args: Array[String]): Unit = {
    println("testing app")
    println("Result:" + MongoHelper.getNoOfDocsInReport(10))
  }
}
