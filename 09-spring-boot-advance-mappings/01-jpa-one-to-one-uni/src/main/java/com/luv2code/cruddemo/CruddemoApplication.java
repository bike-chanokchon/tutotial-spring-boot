package com.luv2code.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	// CommandLineRunner from Spring boot runner
	// Executed after the spring beans have been loaded
	@Bean
	public CommandLineRunner commandLineRunner(String[] args) {

		// Java lambda expression
		return runner -> {
			System.out.println("Hello World");
		};
	}

}
