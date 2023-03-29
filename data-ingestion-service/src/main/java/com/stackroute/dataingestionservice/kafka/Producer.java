package com.stackroute.dataingestionservice.kafka;

import java.time.Instant;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.reactive.ReactiveKafkaProducerTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.dataingestionservice.model.BankDataNormalize;
import com.stackroute.dataingestionservice.model.IngestionServiceLog;
import com.stackroute.dataingestionservice.service.LogService;

@Service
public class Producer {

	@Value(value = "${topicName}")
	private String topic;
	@Autowired
	private LogService logService;
	private final Logger log = LoggerFactory.getLogger(ProducerConfig.class);

	private final ReactiveKafkaProducerTemplate<String, BankDataNormalize> reactiveKafkaProducerTemplate;
   
	public Producer(ReactiveKafkaProducerTemplate<String, BankDataNormalize> reactiveKafkaProducerTemplate,
			LogService logService) {
		this.reactiveKafkaProducerTemplate = reactiveKafkaProducerTemplate;
		this.logService = logService;
	}

	public void send(BankDataNormalize bankDTO) {

		log.info("send to topic={}, {}={},", topic, BankDataNormalize.class.getSimpleName(), bankDTO);
		reactiveKafkaProducerTemplate.send(topic, bankDTO).doOnSuccess(
				senderResult -> log.info("sent {} offset : {}", bankDTO, senderResult.recordMetadata().offset()))
				.subscribe();
		IngestionServiceLog txnLog = new IngestionServiceLog();
		String uuid = UUID.randomUUID().toString();
		Instant date = Instant.now();
		txnLog.setId(uuid);
		txnLog.setPacket_status("Sent");
		txnLog.setCustomer_id(bankDTO.getCustomer_id());
		txnLog.setCreatedAt(date);
		logService.saveUser(txnLog).subscribe();

	}

}
