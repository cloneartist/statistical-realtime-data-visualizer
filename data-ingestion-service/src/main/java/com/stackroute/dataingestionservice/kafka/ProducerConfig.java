package com.stackroute.dataingestionservice.kafka;

import java.util.Map;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;

import com.stackroute.dataingestionservice.model.User;

import reactor.kafka.sender.SenderOptions;

@Configuration
public class ProducerConfig {

	@Bean
	ReactiveKafkaProducerTemplate<String, User> reactiveKafkaProducerTemplate(KafkaProperties properties) {
		Map<String, Object> props = properties.buildProducerProperties();
		return new ReactiveKafkaProducerTemplate<String, User>(SenderOptions.create(props));
	}

}
