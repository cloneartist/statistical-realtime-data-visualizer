package com.stackroute.dataanalyticsservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.dataanalyticsservice.model.Customer;
import com.stackroute.dataanalyticsservice.repository.CustomerRepository;

@Service
public class CustomerServiceImp implements CustomerService {
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Customer saveCustomerService(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> showCustomer() {
		return customerRepository.findAll();
	}
	
	
}
