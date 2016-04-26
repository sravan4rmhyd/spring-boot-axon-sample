package com.sample.todo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Boot Application
 * 
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
}
