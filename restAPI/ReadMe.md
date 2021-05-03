# RestAPI Application with Spring-Boot and Docker

This is a simple spring-boot restAPI application which does Get, GetAll, Post, Put, Delete operations.

# What is a web service ?
Software package for communication between two devices (Server and Client) over the internet

2 types
- Rest - Representational state transfer - Stateless (no client info is stored at server as server does not care about details, it responds to any request) transfer of messages over internet via http protocol
- SOAP - Simple object Access protocol - Provides secured envelope to transfer message over internet using http protocol

# Advantages of Rest

- Loose coupling
- Stateless
- Reduces integration cost
- Simplifies B2B integrations

# Disadvatages od Rest

- Performance issue (can be improved by reactive)
- Stateless - on outages server does not know for which client request failed
- Autosend data to client complicated (unlike websockets)

# When to use ?

- Sync activities
- Request reply
- Fire and Forget
- Get, Post, Put, Delete operations

# When not to use?

- Large number of requests
- Async activities

# Technical Details

# Main App


# Flow of app

main() -> Controller -> Service -> Data

Exceptions -> GeneralExceptionalhandler

# Dependencies
- spring-boot-starter-web (For rest web service)
- lombok (Auto creation Getter, Setter, Builder, Constructors, sl4j logging etc... for data)
- spring-boot-devtools (Optional- To auto restart app on code change in local envs)
- spring-boot-starter-actuator (For metrics related to beans, health, metrics, mapping etc... , Note: http://host:port/actuator has the details, To enable all metrics add 'management.endpoints.web.exposure.include=*' in properties file this enables all metrics related endpoints)

# Testing App

Junit - Mock and Inject Mock
Integration - restTemplate (url, method, Entity/body+header, ResponseObj)

# Dependencies
- spring-boot-starter-test

# CMDS used

- mvnw clean install -> To build jar
- java -jar restAvjPI-0.0.1.jar -> runs the application jar file
- docker build -f Dockerfile -t springboot-restapi . -> Builds the docker image with name (-t) "springboot-restapi" using the contents specified in Dockerfile (-f)
- docker run -p 8080:8080 springboot-restapi -> run the docker container on port 8080 mapped to local port 8080
