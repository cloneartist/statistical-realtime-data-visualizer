package com.stackroute.dataingestionservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.dataingestionservice.model.IngestionServiceLog;
import com.stackroute.dataingestionservice.repository.LogRepository;

import reactor.core.publisher.Mono;

@Service
public class LogServiceImpl implements LogService {
	@Autowired
	private LogRepository logRepository;

	@Autowired
	public LogServiceImpl(LogRepository logRepository) {
		// TODO Auto-generated constructor stub

		this.logRepository = logRepository;
	}

	@Override
	public Mono<IngestionServiceLog> saveUser(IngestionServiceLog log) {
		// TODO Auto-generated method stub

		return logRepository.save(log);
	}
}
