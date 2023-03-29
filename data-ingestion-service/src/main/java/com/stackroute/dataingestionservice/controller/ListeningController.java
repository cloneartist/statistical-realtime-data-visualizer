package com.stackroute.dataingestionservice.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.dataingestionservice.kafka.Producer;
import com.stackroute.dataingestionservice.model.BankDataNormalize;
import com.stackroute.dataingestionservice.model.User;

@RestController
@RequestMapping("/ingestion")
public class ListeningController {
	private final Producer producer;
	private final WebClient webClient;

	private final ObjectMapper objectMapper;

	public ListeningController(Producer producer) {
		this.producer = producer;
		this.webClient = WebClient.create();
		this.objectMapper = new ObjectMapper();
	}

	@GetMapping("/receiveUserData")
	public void startStreaming() {
		webClient.get().uri("http://localhost:9090/streaming/getUserData").accept(MediaType.APPLICATION_STREAM_JSON).retrieve()
				.bodyToFlux(User.class).doOnNext(this::processUser).blockLast();
	}

	private void processUser(User user) {
		try {
			BankDataNormalize model = new BankDataNormalize();
			model.setAge(String.valueOf(user.getAge()));
			model.setBalance(String.valueOf(user.getBalance()));
			model.setCountry((user.getCountry()));
			model.setCredit_card(String.valueOf(user.getCredit_card()));
			model.setCredit_score(String.valueOf(user.getCredit_score()));
			model.setCustomer_id(String.valueOf(user.getCustomer_id()));
			model.setEstimated_salary(String.valueOf(user.getEstimated_salary()));
			model.setGender(String.valueOf(user.getGender()));
//			String json = objectMapper.writeValueAsString(user);
//			System.out.println(json);
			this.producer.send(model);
			String json = objectMapper.writeValueAsString(user);
			System.out.println(json);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

}