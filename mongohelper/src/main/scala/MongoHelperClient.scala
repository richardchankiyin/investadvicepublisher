package com.richard.mongohelper

import org.mongodb.scala._
import org.mongodb.scala.model.Filters._
import scala.concurrent.Await
import scala.concurrent.duration._
import org.mongodb.scala.model.Projections._
import org.mongodb.scala.model.Sorts._

object MongoHelper {
   val host="localhost"
   val port="50000"
   val replicaset = "rs"
   //val mongoClient:MongoClient = MongoClient()
   val mongoClient:MongoClient = MongoClient(s"mongodb://$host:$port/?replicaSet=$replicaset")
   val db = "investadviceapp"
   val mongodatabase:MongoDatabase = mongoClient.getDatabase(db)
   val reportCollString = "report"

   val reportCollection:MongoCollection[Document] = mongodatabase.getCollection(reportCollString)

   def getNoOfDocsInReport(time:Int=10) = Await.result(reportCollection.count().toFuture(),time second)

   def getDocById(id:String, time:Int=10) = Await.result(reportCollection.find(equal("id",id)).first().toFuture(),time second).toJson

   def findDocBySymbol(symbol:String, size:Int=50, time:Int=10) = Await.result(reportCollection.find(equal("symbol",symbol)).sort(orderBy(descending("time"))).projection(fields(include("id"), excludeId())).limit(size).toFuture(), time second).map(i=>i.get("id") match { case Some(bs) => bs.asString.getValue; case None => "" })
}
