package com.stackroute.dataingestionservice.service;

import java.util.List;

import com.stackroute.dataingestionservice.model.IngestionServiceLog;

import reactor.core.publisher.Mono;

public interface LogService {
	Mono<IngestionServiceLog> saveUser(IngestionServiceLog log);

	Mono<List<IngestionServiceLog>> showLog();
}
