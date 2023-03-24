package com.stackroute.dataingestionservice.service;

import com.stackroute.dataingestionservice.model.IngestionServiceLog;

import reactor.core.publisher.Mono;

public interface LogService {

	// gets a user object, saves it in the repository and returns a mono of that
	// user
	Mono<IngestionServiceLog> saveUser(IngestionServiceLog log);
}
