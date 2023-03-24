package com.stackroute.dataingestionservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.dataingestionservice.model.BankDataNormalize;
import com.stackroute.dataingestionservice.service.UserService;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void saveUser(@RequestBody BankDataNormalize bankDataNormalize) {
		userService.sendUser(bankDataNormalize);
	}
}
