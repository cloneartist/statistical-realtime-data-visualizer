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

	public AnalyticsServiceLog saveLog(BankRecieveModel bankModel) {
		AnalyticsServiceLog txnLog = new AnalyticsServiceLog();
		UUID uuid = UUID.randomUUID();
		Date date = Calendar.getInstance().getTime();
		txnLog.setId(uuid);
		txnLog.setPacket_status("Recieved");
		txnLog.setCustomer_id(bankModel.getCustomer_id());
		txnLog.setCreatedAt(date);
		AnalyticsServiceLog savedLog = logRepository.save(txnLog);
		return savedLog;
	}

	public List<AnalyticsServiceLog> showLog() {
		// TODO Auto-generated method stub
		
		return logRepository.findAll();
	}
}
