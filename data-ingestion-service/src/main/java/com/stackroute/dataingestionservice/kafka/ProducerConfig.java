package com.stackroute.dataingestionservice.kafka;

import java.util.Map;

import com.stackroute.dataingestionservice.model.BankDataNormalize;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;

import reactor.kafka.sender.SenderOptions;

@Configuration
public class ProducerConfig {

	@Bean
	ReactiveKafkaProducerTemplate<String, BankDataNormalize> reactiveKafkaProducerTemplate(KafkaProperties properties) {
		Map<String, Object> props = properties.buildProducerProperties();
		return new ReactiveKafkaProducerTemplate<String, BankDataNormalize>(SenderOptions.create(props));
	}

}
