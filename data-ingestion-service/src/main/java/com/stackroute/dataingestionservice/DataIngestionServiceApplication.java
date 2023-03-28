package com.stackroute.dataingestionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;


@SpringBootApplication
@ComponentScan("com.stackroute")
@EnableR2dbcRepositories(basePackages = { "stackroute.dataingestionservice.repository" }, basePackageClasses = {})
@EnableDiscoveryClient
public class DataIngestionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataIngestionServiceApplication.class, args);
	}

}
