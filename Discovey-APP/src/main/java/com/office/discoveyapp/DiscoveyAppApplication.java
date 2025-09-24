package com.office.discoveyapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveyAppApplication.class, args);
	}

}
