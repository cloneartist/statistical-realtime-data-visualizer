package com.stackroute.dataingestionservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.dataingestionservice.model.User;
import com.stackroute.dataingestionservice.service.UserService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<User> saveUser(@RequestBody User user) {
		return userService.sendUser(user);
	}
}
