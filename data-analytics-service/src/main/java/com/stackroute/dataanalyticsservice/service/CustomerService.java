package com.stackroute.dataanalyticsservice.service;

import java.util.List;

import com.stackroute.dataanalyticsservice.exceptions.CustomerAlreadyExistException;
import com.stackroute.dataanalyticsservice.model.Customer;

public interface CustomerService {

	Customer saveCustomer(Customer customer) throws CustomerAlreadyExistException;

	List<Customer> showCustomer();

}
