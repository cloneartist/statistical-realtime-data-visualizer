package com.stackroute.dataanalyticsservice.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.dataanalyticsservice.exceptions.CustomerAlreadyExistException;
import com.stackroute.dataanalyticsservice.model.BankRecieveModel;
import com.stackroute.dataanalyticsservice.model.Customer;
import com.stackroute.dataanalyticsservice.service.BankService;
import com.stackroute.dataanalyticsservice.service.CountryService;
import com.stackroute.dataanalyticsservice.service.CustomerService;
import com.stackroute.dataanalyticsservice.service.LogService;

@Service
public class Consumer {
	@Autowired
	private BankService bankService;
	@Autowired
	private LogService logService;

	@Autowired
	private CustomerService customerService;
	@Autowired
	private CountryService countryService;

	@KafkaListener(topics = "bank_topic", groupId = "group_bank")
	public void consume(BankRecieveModel banktxn) {
		System.out.println("Recieved" + banktxn);
		Customer customer = new Customer();
		customer.setAge(Integer.parseInt(banktxn.getAge()));
		customer.setBalance((int) Double.parseDouble(banktxn.getBalance()));
		customer.setCountry(banktxn.getCountry());
		customer.setCredit_card(Integer.parseInt(banktxn.getCredit_card()));
		customer.setCredit_score(Integer.parseInt(banktxn.getCredit_score()));
		customer.setCustomer_id(Long.parseLong(banktxn.getCustomer_id()));
		customer.setEstimated_salary(Double.parseDouble(banktxn.getEstimated_salary()));
		customer.setGender(banktxn.getGender());
		logService.saveLog(banktxn);
		bankService.saveTxn(banktxn);
		try {
			customerService.saveCustomer(customer);
		} catch (CustomerAlreadyExistException e) {
			e.printStackTrace();
		}

	}
}
