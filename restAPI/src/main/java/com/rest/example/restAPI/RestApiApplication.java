package com.rest.example.restAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*
@SpringBootApplication provides
@SpringBootConfiguration - Enables SpringBoot configs
@EnableAutoConfiguration - Enables auto configs of spring boot like port etc..
@ComponentScan - Scans the classes with the @Component annotation which acts as beans for IOC at boot time
 */
@SpringBootApplication
public class RestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

}
