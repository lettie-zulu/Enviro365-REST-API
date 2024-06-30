package com.enviro.assessment.grad001.lettiezulu;//This is a package declaration where the this class resides.


import org.springframework.boot.SpringApplication;//a class that provides a way to bootstrap a spring application from a java main method.
import org.springframework.boot.autoconfigure.SpringBootApplication;//a way to add other required annotations like @configuration etc.
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;//This tells spring boot to start adding beens based on classpath settings,other beens and property settings.

@SpringBootApplication//this annotation enables auto-configuration, component scanning and property support.
public class Enviro365Application {
//this is the main method which is called when the application is started.
	public static void main(String[] args) {
		SpringApplication.run(Enviro365Application.class, args);//the static method starts the spring application context.
	}

}
//summary:
//the package organizes the class within the project structure.
// the imports include necessary spring boot and jpa configurations.
//the main class marks the entry point of the spring boot application.
//the main method runs the application using SpringApplication.run.