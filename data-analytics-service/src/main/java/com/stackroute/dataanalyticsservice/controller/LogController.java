package com.stackroute.dataanalyticsservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.dataanalyticsservice.model.AnalyticsServiceLog;
import com.stackroute.dataanalyticsservice.service.LogService;

@RestController
public class LogController {
	
	@Autowired
	LogService logservice;
	
	@GetMapping("/receive_log")
	public List<AnalyticsServiceLog> showLog(){
		return logservice.showLog();
	}
}
