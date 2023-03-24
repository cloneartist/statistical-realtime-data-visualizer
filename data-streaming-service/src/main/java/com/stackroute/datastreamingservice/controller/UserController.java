package com.stackroute.datastreamingservice.controller;

//import java.io.File;
//
//import java.io.IOException;
//import java.time.Duration;
//
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.datastreamingservice.model.User;
//
//import reactor.core.publisher.Flux;
//
//@RestController
//public class UserController {
//
//	@GetMapping(value = "/stream", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
//	public Flux<User> stream() throws IOException {
//
//		ObjectMapper objectMapper = new ObjectMapper();
//		User userArray[] = objectMapper.readValue(new File("src/main/resources/data/data.json"), User[].class);
//
//		return Flux.just(userArray).delayElements(Duration.ofSeconds(1));
//
//	}
//
//}


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.datastreamingservice.model.User;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class UserController {

	@GetMapping(value = "/stream", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<User> stream() throws IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		User userArray[] = objectMapper.readValue(new File("src/main/resources/data/data.json"), User[].class);

		return Flux.fromArray(userArray).delayElements(Duration.ofSeconds(1));

	}

}
