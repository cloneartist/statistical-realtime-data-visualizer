package com.stackroute.dataingestionservice.service;

import com.stackroute.dataingestionservice.model.User;

import reactor.core.publisher.Mono;

public interface UserService {

	// gets a user object, saves it in the repository and returns a mono of that
	// user
	Mono<User> saveUser(User user);

}
