package com.stackroute.dataingestionservice.service;

import com.stackroute.dataingestionservice.model.User;

import reactor.core.publisher.Mono;

public interface UserService {

	Mono<User> sendUser(User user);

}
