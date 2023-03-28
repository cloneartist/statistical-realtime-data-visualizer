package com.stackroute.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
		return builder.routes().route(r->r.path("/analytics/**").uri("lb://Data-Analytics-Service"))
				.route(r->r.path("/ingestion/**").uri("lb://Data-Ingestion-Service"))
				.route(r->r.path("/streaming/**").uri("lb://Data-Streaming-Service"))
				.route(r->r.path("/**").uri("lb://WebApp-Frontend-Service")).build();

	}


}
