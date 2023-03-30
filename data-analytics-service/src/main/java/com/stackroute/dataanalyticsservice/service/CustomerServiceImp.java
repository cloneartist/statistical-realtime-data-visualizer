package com.stackroute.dataanalyticsservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.dataanalyticsservice.exceptions.CustomerAlreadyExistException;
import com.stackroute.dataanalyticsservice.model.Customer;
import com.stackroute.dataanalyticsservice.repository.CustomerRepository;

@Service
public class CustomerServiceImp implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CountryService countryService;
	
	
	//This method performs two actions , one in customer table and another in country table
	//Adds new customer data to customer table
	//updates or adds country data received from customer data to country table
	@Override
	public Customer saveCustomer(Customer customer) throws CustomerAlreadyExistException{
		
		//checking whether the given customer is null
		if(customer==null) {
			return null;
		}
		
		// Checking whether the given customer already exist in the customer repository
		if (this.customerRepository.findById(customer.getCustomer_id()).isPresent()) {
			throw new CustomerAlreadyExistException("The given Customer with customer_id "+customer.getCustomer_id()+" already exists in the customer repository");
		}
		
		//Creating country repository data from the given customer data
		countryService.AggregateCountryDataOrAddCountry(customer.getCountry(), customer.getCredit_score(),
				customer.getEstimated_salary());

		// Adding customer data to the customer repository
		return customerRepository.save(customer);
	}
	
	
	
	//fetches all the customer data from customer table
	@Override
	public List<Customer> showCustomer() {
		return customerRepository.findAll();
	}

	@Override
	public void deleteCustomers() {
		customerRepository.deleteAll();
	}

}
