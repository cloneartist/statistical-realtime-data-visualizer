package com.stackroute.dataanalyticsservice.service;

import java.util.List;

import com.stackroute.dataanalyticsservice.model.Customer;

public interface CustomerService {

	Customer saveCustomer(Customer customer);

	List<Customer> showCustomer();

}
