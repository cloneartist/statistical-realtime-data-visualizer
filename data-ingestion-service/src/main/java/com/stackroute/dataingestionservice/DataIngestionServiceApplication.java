package com.stackroute.dataingestionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class DataIngestionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataIngestionServiceApplication.class, args);
	}

}
