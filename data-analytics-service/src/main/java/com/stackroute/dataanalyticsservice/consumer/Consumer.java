package com.stackroute.dataanalyticsservice.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.dataanalyticsservice.exceptions.CustomerAlreadyExistException;
import com.stackroute.dataanalyticsservice.model.BankRecieveModel;
import com.stackroute.dataanalyticsservice.model.Customer;
import com.stackroute.dataanalyticsservice.service.CustomerService;
import com.stackroute.dataanalyticsservice.service.LogService;

@Service
public class Consumer {

	@Autowired
	private LogService logService;

	@Autowired
	private CustomerService customerService;

	@KafkaListener(topics = "bank_topic", groupId = "group_bank")
	// Consume the data from kafka using the same Model as the producer
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

		try {
			// save data using customer service.
			customerService.saveCustomer(customer);
		} catch (CustomerAlreadyExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
