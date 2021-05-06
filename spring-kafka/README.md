# Spring-Kafka

# What is Kafka
Opensource framework for reading, processing data.

# Kafka concepts
1. Message: data
2. Producer: Application that sends message to server/ broker
3. Consumer: Application that consumes message from server
4. Broker: Kafka Server
5. Kafka cluster: group of servers/ brokers
6. Topic: Logical partitioning of data. Ex: price topic holds price data
7. Partitions - storing data in multiple parts/ servers.  Large volume of data better to split and store it onto multiple parts,
   there by achieving distributed system.
8. Offset - seq id for data in topic. To locate a msg: topic + partition + offset.
9. Consumer Group: group of consumers that share the work.
   10: Zookeeper: Tracks topics, partitions, cluster status, writes to leader/follower topics etc...

# Y Kafka ?
- Opensource
- High throughput
- Low latency
- Horizontal scaling
- Distributed system (partitions)
- Fault tolerant

# Y no to Kafka ?
- Lack of monitoring tools
- No message priority

# When Kafka ?
- Event Driven Architecture
- Realtime data processing
- Monitoring

# When no to Kafka ?
- Not for storing data: use DB
- not for small quantity of data: over-kill
- Not for routing logics: use MQ
- Not for request-response architecture: use rest-apis

# spring-kafka Application

- Work flow

RestController -> KafkaProducer -> broker

broker -> kafkaConsumer(poll)

# Dependencies
- Spring-boot-starter-web
- Spring-Kafka

# How to run this app
- cmds
1. docker-compose up
2. mvnw clean install
3. java -jar kafka-server-0.0.1.jar
4. POST method call <host:port>/api/v1/post, content-type: application/json, body: { "id": 1, "fullName": "Bruce Wayne", "role": "Engineer" }
