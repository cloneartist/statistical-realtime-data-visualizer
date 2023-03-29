package com.stackroute.dataingestionservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.dataingestionservice.model.IngestionServiceLog;
import com.stackroute.dataingestionservice.service.LogService;

import reactor.core.publisher.Mono;

@RestController
public class LogController {
	
	@Autowired
	LogService logService;
	//Mapping to get all logs of data that has been sent
	@GetMapping("/sent_log")
	public Mono<List<IngestionServiceLog>> showLog(){
		return logService.showLog();
	}
}
