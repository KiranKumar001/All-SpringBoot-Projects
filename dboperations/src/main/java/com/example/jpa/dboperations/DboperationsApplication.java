package com.example.jpa.dboperations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class DboperationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DboperationsApplication.class, args);
	}

}
