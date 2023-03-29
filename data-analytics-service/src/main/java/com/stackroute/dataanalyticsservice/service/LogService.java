package com.stackroute.dataanalyticsservice.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.dataanalyticsservice.model.AnalyticsServiceLog;
import com.stackroute.dataanalyticsservice.model.BankRecieveModel;
import com.stackroute.dataanalyticsservice.repository.LogRepository;

@Service
public class LogService {
	@Autowired
	private LogRepository logRepository;
	
	//saves the log data in log table which is received from the kafka messaging queue
	public AnalyticsServiceLog saveLog(BankRecieveModel bankModel) {
		AnalyticsServiceLog analyticsServiceLog = new AnalyticsServiceLog();
		
		//generating the random id for the log
		UUID uuid = UUID.randomUUID();
		
		//Getting the time at which that Log has been received
		Date date = Calendar.getInstance().getTime();
		
		//setting the values of analyticsServiceLpg
		analyticsServiceLog.setId(uuid);
		analyticsServiceLog.setPacket_status("Recieved");
		analyticsServiceLog.setCustomer_id(bankModel.getCustomer_id());
		analyticsServiceLog.setCreatedAt(date);
		
		//addding received Log data to the LogRepository
		AnalyticsServiceLog savedLog = logRepository.save(analyticsServiceLog);
		return savedLog;
	}
	
	
	//fetches all the log data from the log table
	public List<AnalyticsServiceLog> showLog() {
		return logRepository.findAll();
	}
}
