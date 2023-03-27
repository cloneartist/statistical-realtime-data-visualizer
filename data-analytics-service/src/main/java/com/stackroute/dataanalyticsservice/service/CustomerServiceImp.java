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

	@Autowired
	CountryService countryService;

	@Override
	public Customer saveCustomer(Customer customer) {

		// Checking whether the given customer already exist in the customer repository
		// , in case if the same customer customer exists
		// then do not perform any operation
		if (this.customerRepository.findById(customer.getCustomer_id()).isPresent()) {
			return customer;
		}

		// Creating country repository data from the given customer data
		countryService.AggregateCountryDataOrAddCountry(customer.getCountry(), customer.getCredit_score(),
				customer.getEstimated_salary());

		// Adding customer data to the customer repository
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> showCustomer() {
		return customerRepository.findAll();
	}

}
