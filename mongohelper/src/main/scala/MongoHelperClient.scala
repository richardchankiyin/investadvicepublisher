package com.richard.mongohelper

import org.mongodb.scala._
import scala.concurrent.Await
import scala.concurrent.duration._

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
}
