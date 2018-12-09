investadvicepublisher
=====================
This repository demonstrates a platform to publish json based investment advices/research. Extraction can be done in restapi

Prerequsite
------------
- linux/unix/mac
- mongodb 3.6 or above
- scala 2.12.x
- sbt

Setup
-----
- init mongodb: cd mongodb; ./mongostart.sh
- init replicaSet: login to mongodb and run rs.initiate()
(detail pls refer to: https://docs.mongodb.com/manual/reference/method/rs.initiate/ )
- setup scaledrone account and get a channel id
(detail pls refer to: https://www.scaledrone.com)
- create a file called channelid under mongodb folder and put the scaledrone channel id to that file (without any leading space)
- sbt build: cd investadvicereqres; sbt clean compile 
