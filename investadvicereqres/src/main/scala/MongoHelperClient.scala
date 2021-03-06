package com.richard.investadvicereqres

import org.mongodb.scala._
import org.mongodb.scala.model.Filters._
import scala.concurrent.Await
import scala.concurrent.duration._
import org.mongodb.scala.model.Projections._
import org.mongodb.scala.model.Sorts._
import com.mongodb.client.model.changestream.ChangeStreamDocument
import org.mongodb.scala.bson.BsonDocument
import org.mongodb.scala.Document

object MongoHelper {
   val host="localhost"
   val port="50000"
   val replicaset = "rs"
   //val mongoClient:MongoClient = MongoClient()
   val mongoClient:MongoClient = MongoClient(s"mongodb://$host:$port/?replicaSet=$replicaset")
   val db = "investadviceapp"
   val mongodatabase:MongoDatabase = mongoClient.getDatabase(db)
   val reportCollString = "report"
   val newsCollString = "news"

   val reportCollection:MongoCollection[Document] = mongodatabase.getCollection(reportCollString)

   val newsCollection:MongoCollection[Document] = mongodatabase.getCollection(newsCollString)

   def getNoOfDocsInReport(time:Int=10) = Await.result(reportCollection.count().toFuture(),time second)

   def getDocById(id:String, time:Int=10) = Await.result(reportCollection.find(equal("id",id)).projection(fields(excludeId())).first().toFuture(),time second).toJson

   def findDocBySymbol(symbol:String, size:Int=50, time:Int=10) = Await.result(
         reportCollection.find(equal("symbol",symbol))
             .sort(orderBy(descending("time")))
                .projection(fields(include("id"), excludeId()))
                    .limit(size).toFuture(), time second)
                        .map(i=>i.get("id") match 
                            { case Some(bs) => bs.asString.getValue
                              case None => "" })
   

   val observer = new Observer[ChangeStreamDocument[Document]] {
      //def getResumeToken: BsonDocument = Document().underlying
      override def onNext(result: ChangeStreamDocument[Document]): Unit = { println (result) }
      override def onError(e: Throwable): Unit = {}
      override def onComplete(): Unit = {}
   }
   
   def watchNews() = {
      newsCollection.watch().subscribe(observer);
   }
}
