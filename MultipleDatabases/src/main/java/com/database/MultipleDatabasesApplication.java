package com.database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MultipleDatabasesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultipleDatabasesApplication.class, args);
		System.out.println("application started...");
	}

}
