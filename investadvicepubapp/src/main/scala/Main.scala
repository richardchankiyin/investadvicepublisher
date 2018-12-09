package com.richard.investadvicepubapp

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.stereotype.Controller
import org.springframework.context.annotation.Configuration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.boot.SpringApplication
import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory

object Main {
  def test(args: Array[String]): Unit = {
    println("testing app")
    println("Report no:" + MongoHelper.getNoOfDocsInReport(10))
    println("doc report0001: " + MongoHelper.getDocById("report0001"))
    println("doc symbol 0005.HK: " + MongoHelper.findDocBySymbol("0005.HK"))
    println("doc symbol 2318.HK: " + MongoHelper.findDocBySymbol("2318.HK"))
  }

  def main(args: Array[String]): Unit = runSpring(args)

  def runSpring(args: Array[String]): Unit = {
      SpringApplication.run(classOf[SpringApp])
  }
}

@Controller
@Configuration
@EnableAutoConfiguration
@ComponentScan
@RequestMapping(Array("/"))
class SpringApp {
    val logger = Logger(LoggerFactory.getLogger(this.getClass))
    @RequestMapping(Array("/home"))
    @ResponseBody
    def home:String = "InvestServicePubApp Home\n" 

    @RequestMapping(value=Array("/getdoc/{id}"), method=Array(RequestMethod.GET))
    @ResponseBody
    def getDocById(@PathVariable("id") id:String) = { 
       logger.info("getDocById: {}", id) 
       try {
          MongoHelper.getDocById(id)
       } catch {
          case t: java.lang.Throwable => {
             logger.error(s"getDocById $id", t)
             throw new java.lang.IllegalArgumentException(s"docid $id invalid")
          }
       }
    }

    @RequestMapping(value=Array("/finddocbysymbol/{symbol}"), method=Array(RequestMethod.GET))
    @ResponseBody
    def findDocBySymbol(@PathVariable("symbol") symbol:String) = {
        logger.info("findDocBySymbol: {}", symbol)
        try {
           val result = MongoHelper.findDocBySymbol(symbol).toArray
           //logger.info("result value: {} class: {}", {result.toString}, {result.getClass})
           result

        } catch {
           case t: java.lang.Throwable => {
             logger.error(s"findDocBySymbol $symbol", t)
             throw new java.lang.IllegalStateException(s"$symbol has no doc")
           }
        }
    }
}
