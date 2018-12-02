package com.richard.mongohelper

object Main {
  def main(args: Array[String]): Unit =
    println("no of doc in report: " + MongoHelper.getNoOfDocsInReport)
}
