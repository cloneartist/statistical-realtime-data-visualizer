package com.stackroute.dataingestionservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.dataingestionservice.kafka.Producer;
import com.stackroute.dataingestionservice.model.User;

import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {
	private Producer producer;

	@Autowired
	public UserServiceImpl(Producer producer) {
		this.producer = producer;
	}

	@Override
	public Mono<User> saveUser(User user) {

		producer.send(user);
		return null;

	}

}
