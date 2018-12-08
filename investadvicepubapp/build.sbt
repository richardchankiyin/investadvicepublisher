ThisBuild / organization := "com.richard.investadvicepubapp"
ThisBuild / scalaVersion := "2.12.7"
// set the Scala version used for the project
ThisBuild / version      := "0.1.0-SNAPSHOT"


// Set to false or remove if you want to show stubs as linking errors
nativeLinkStubs := false
// https://mvnrepository.com/artifact/org.mongodb.scala/mongo-scala-driver
libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "2.5.0"

//enablePlugins(ScalaNativePlugin)
