ThisBuild / organization := "com.richard.investadvicereqres"
ThisBuild / scalaVersion := "2.12.7"
// set the Scala version used for the project
ThisBuild / version      := "0.1.0-SNAPSHOT"


// Set to false or remove if you want to show stubs as linking errors
nativeLinkStubs := false
// https://mvnrepository.com/artifact/org.mongodb.scala/mongo-scala-driver
libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "2.5.0"

// https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web
libraryDependencies += "org.springframework.boot" % "spring-boot-starter-web" % "1.5.18.RELEASE"
// https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-websocket
libraryDependencies += "org.springframework.boot" % "spring-boot-starter-websocket" % "1.5.18.RELEASE"

libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.7.0"

libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.13"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.2"

//enablePlugins(ScalaNativePlugin)
