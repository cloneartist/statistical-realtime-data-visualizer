package com.stackroute.dataingestionservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.dataingestionservice.kafka.Producer;
import com.stackroute.dataingestionservice.model.BankDataNormalize;
import com.stackroute.dataingestionservice.model.User;

@Service
public class ListeningService {
	private final Producer producer;
	private final WebClient webClient;
	private final ObjectMapper objectMapper;
	private static final Logger logger = LoggerFactory.getLogger(ListeningService.class);

	public ListeningService(Producer producer) {
		this.producer = producer;
		this.webClient = WebClient.create();
		this.objectMapper = new ObjectMapper();
	}

	public void startStreaming() {
		logger.info("Began receiving Json Data");
		webClient.get().uri("http://localhost:8080/streaming/getUserData").accept(MediaType.APPLICATION_STREAM_JSON)
				.retrieve().bodyToFlux(User.class).doOnNext(this::processUser).subscribe();
		logger.info("Completed receiving Json Data");
	}

	private void processUser(User user) {
		try {
			logger.info("processing user:{}", user.toString());
			BankDataNormalize model = new BankDataNormalize();
			model.setAge(String.valueOf(user.getAge()));
			model.setBalance(String.valueOf(user.getBalance()));
			model.setCountry((user.getCountry()));
			model.setCredit_card(String.valueOf(user.getCredit_card()));
			model.setCredit_score(String.valueOf(user.getCredit_score()));
			model.setCustomer_id(String.valueOf(user.getCustomer_id()));
			model.setEstimated_salary(String.valueOf(user.getEstimated_salary()));
			model.setGender(String.valueOf(user.getGender()));
			this.producer.send(model);
			logger.info("Sending the mapped BankDataNormalize object to Kafka");
		} catch (Exception e) {
			logger.info("Exception found");
			e.printStackTrace();
		}
	}
}
