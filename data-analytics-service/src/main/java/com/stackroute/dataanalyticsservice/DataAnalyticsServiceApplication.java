package com.stackroute.dataanalyticsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


//This microservice receives the customer data from the kafka messaging queue and stores the data into two tables
//one in customer table and another in country table and provides APIs form these tables
//These APIs will be used in the frontend 
@SpringBootApplication
@EnableDiscoveryClient 
public class DataAnalyticsServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(DataAnalyticsServiceApplication.class, args);
	}

}