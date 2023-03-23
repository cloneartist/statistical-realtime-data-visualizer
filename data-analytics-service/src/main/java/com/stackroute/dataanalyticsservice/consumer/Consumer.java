package com.stackroute.dataanalyticsservice.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.dataanalyticsservice.model.BankRecieveModel;
import com.stackroute.dataanalyticsservice.service.BankService;
import com.stackroute.dataanalyticsservice.service.LogService;

@Service
public class Consumer {
	@Autowired
	private BankService bankService;
	@Autowired
	private LogService logService;

	@KafkaListener(topics = "bank_topic", groupId = "group_bank")
	public void consume(BankRecieveModel banktxn) {
		System.out.println("Recieved" + banktxn);

		logService.saveLog(banktxn);
		bankService.saveTxn(banktxn);

	}
}
