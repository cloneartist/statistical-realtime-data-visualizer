package com.stackroute.dataingestionservice.service;

import org.springframework.stereotype.Service;

import com.stackroute.dataingestionservice.kafka.Producer;
import com.stackroute.dataingestionservice.model.BankDataNormalize;

@Service
public class UserServiceImpl implements UserService {
	private Producer producer;

	public UserServiceImpl(Producer producer) {
		this.producer = producer;
	}

	@Override
	public void sendUser(BankDataNormalize bankDataNormalize) {
		producer.send(bankDataNormalize);

	}

}
