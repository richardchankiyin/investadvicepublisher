package com.richard.investadvicepubapp

object Main {
  def main(args: Array[String]): Unit = {
    println("testing app")
    println("Report no:" + MongoHelper.getNoOfDocsInReport(10))
    println("doc report0001: " + MongoHelper.getDocById("report0001"))
    println("doc symbol 0005.HK: " + MongoHelper.findDocBySymbol("0005.HK"))
    println("doc symbol 2318.HK: " + MongoHelper.findDocBySymbol("2318.HK"))
  }
}
