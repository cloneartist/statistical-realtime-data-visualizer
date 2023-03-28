package com.stackroute.dataanalyticsservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.dataanalyticsservice.model.BankRecieveModel;
import com.stackroute.dataanalyticsservice.repository.BankRepository;

@Service

public class BankService {
	@Autowired
	private BankRepository bankRepository;

	public BankRecieveModel saveTxn(BankRecieveModel banktxn) {
		BankRecieveModel savedTxn = bankRepository.save(banktxn);
		return savedTxn;
	}

}
