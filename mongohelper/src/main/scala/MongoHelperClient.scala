package com.richard.mongohelper

import org.mongodb.scala._

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

   def getNoOfDocsInReport = reportCollection.count().subscribe(new Observer[Long] {
       override def onNext(result: Long): Unit = print(result)
       override def onError(e: Throwable): Unit = {}
       override def onComplete(): Unit = {}
   }) 
}
