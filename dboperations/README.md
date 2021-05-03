# SpringBoot-JPA-APP

This is a simple app to connect to postgres db and perform CURD operations upon rest API (GET, POST, PUT, DELETE) calls

# Dependencies
-spring-boot-starter-actuator: for actuator metrics
-spring-boot-starter-data-jpa: for jpa operations save(), findAll(), findById(), Delete() etc...
-spring-boot-starter-web - for rest API
-spring-boot-devtools: for auto restart of servers in local envs upon code change
-postgresql: for postgres drivers
-spring-boot-starter-test: for app test
-lombok: for logs, getters, setters, constructors, builders, toString etc...

# Application Flow

Controller -> Service -> Repository -> Data

Exception -> GlobalExceptionHandler

# Property file

## DB details and connection parameters
-spring.datasource.url=jdbc:postgresql://localhost:5432/employees

-spring.datasource.username=postgres

-spring.datasource.password=******

-spring.jpa.show-sql=true

## Hibernate Properties
# better SQl generation
-spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQL9Dialect

# Hibernate auto ddl
-spring.jpa.hibernate.ddl-auto = update

## enable all actuator endpoints
-management.endpoints.web.exposure.include=*

# CMDS used

- mvnw clean install -> To build jar
- java -jar restAvjPI-0.0.1.jar -> runs the application jar file

# Further enhancements

TestContainers can be used for integration test

