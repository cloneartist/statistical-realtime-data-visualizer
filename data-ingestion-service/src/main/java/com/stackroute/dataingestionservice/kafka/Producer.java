package com.stackroute.dataingestionservice.kafka;

import java.time.Instant;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.dataingestionservice.model.IngestionServiceLog;
import com.stackroute.dataingestionservice.model.User;
import com.stackroute.dataingestionservice.service.LogService;

@Service
public class Producer {

	@Value(value = "${topicName}")
	private String topic;
	@Autowired
	private LogService logService;
	private final Logger log = LoggerFactory.getLogger(ProducerConfig.class);

	private final ReactiveKafkaProducerTemplate<String, User> reactiveKafkaProducerTemplate;

	public Producer(ReactiveKafkaProducerTemplate<String, User> reactiveKafkaProducerTemplate, LogService logService) {
		this.reactiveKafkaProducerTemplate = reactiveKafkaProducerTemplate;
		this.logService = logService;
	}

	public void send(User userDTO) {

		log.info("send to topic={}, {}={},", topic, User.class.getSimpleName(), userDTO);
		reactiveKafkaProducerTemplate.send(topic, userDTO).doOnSuccess(
				senderResult -> log.info("sent {} offset : {}", userDTO, senderResult.recordMetadata().offset()))
				.subscribe();
		IngestionServiceLog txnLog = new IngestionServiceLog();
		String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
		Instant date = Instant.now();
		txnLog.setId(uuid);
		txnLog.setPacket_status("Sent");
		txnLog.setCustomer_id(userDTO.getCustomer_id());
		txnLog.setCreatedAt(date);
		logService.saveUser(txnLog).subscribe();

	}

}
