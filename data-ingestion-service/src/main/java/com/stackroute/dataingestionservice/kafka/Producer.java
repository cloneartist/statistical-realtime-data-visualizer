package com.stackroute.dataingestionservice.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.dataingestionservice.model.User;

@Service
public class Producer {

	@Value(value = "${topicName}")
	private String topic;

	private final Logger log = LoggerFactory.getLogger(ProducerConfig.class);

	private final ReactiveKafkaProducerTemplate<String, User> reactiveKafkaProducerTemplate;

	@Autowired
	public Producer(ReactiveKafkaProducerTemplate<String, User> reactiveKafkaProducerTemplate) {
		this.reactiveKafkaProducerTemplate = reactiveKafkaProducerTemplate;
	}

	public void send(User userDTO) {
		log.info("send to topic={}, {}={},", topic, User.class.getSimpleName(), userDTO);
		reactiveKafkaProducerTemplate.send(topic, userDTO).doOnSuccess(
				senderResult -> log.info("sent {} offset : {}", userDTO, senderResult.recordMetadata().offset()))
				.subscribe();
	}

}
