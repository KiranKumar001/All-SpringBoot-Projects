# Spring-MQ

This spring boot application produces and consumes msgs from an IBM MQ

# Dependencies
- spring-boot-starter-web
- jackson-databind
- mq-jms-spring-boot-starter

# Configs
below configs are mandatory to register sender and receiver.
- ibm.mq.queueManager=<QM>
- ibm.mq.channel=<SVRCONN_CHANNEL>
- ibm.mq.connName=<host>(<port>)
- ibm.mq.user=<userID>
- ibm.mq.password=<password>

# What is MQ?
Framework that allows async communication between applications

# MQ components
- Message - data
- Message Broker - Server which establishes communication between applications and helps in routing

# Y or when MQ?
- Async communication
- loosely coupled applications
- Routing

# Y/When not to MQ?
- No message retention
- slow
- push model - queue pushes msg to receiver/consumer which might overwelm the consumer if there is huge volume of messages.

# How to start this application

- Spin up ibm-mq docker container
  docker run --env LICENSE=accept --env MQ_QMGR_NAME=QM1 --publish 1414:1414 --publish 9443:9443 --detach ibmcom/mq
  
- Build application
 mvnw clean install
  
- Run Application
 java -jar spring-mq-0.0.1.jar
  
- Publish msg to MQ
PUT: localhost:8080/api/v1/put/Hello!!!
  
- Get Msg from MQ
GET: localhost:8080/api/v1/get


