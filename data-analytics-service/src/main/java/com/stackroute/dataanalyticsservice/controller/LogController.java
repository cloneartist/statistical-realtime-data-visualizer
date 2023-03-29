package com.stackroute.dataanalyticsservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.dataanalyticsservice.model.AnalyticsServiceLog;
import com.stackroute.dataanalyticsservice.service.LogService;


//LogController provides API to see the log data of the data received
//Log data contains the information such as at what time analytics service  received the data from kafka
@RestController
public class LogController {
	
	@Autowired
	LogService logservice;
	
	//An API that provides the log data of analytics service
	@GetMapping("/receive_log")
	public List<AnalyticsServiceLog> showLog(){
		return logservice.showLog();
	}
}
