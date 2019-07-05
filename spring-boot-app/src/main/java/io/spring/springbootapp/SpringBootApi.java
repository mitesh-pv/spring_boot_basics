package io.spring.springbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Step 1: tell the project that the class with main method id the starting point of the project by this annotation
@SpringBootApplication
public class SpringBootApi {

	public static void main(String[] args) {
		// Step 2: pass the class name containing the main method to the SpringApplication.run method
		SpringApplication.run(SpringBootApi.class, args);
	}

}
