package com.stackroute.dataanalyticsservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.dataanalyticsservice.model.Customer;
import com.stackroute.dataanalyticsservice.service.CountryService;
import com.stackroute.dataanalyticsservice.service.CustomerService;

@RestController
@RequestMapping("analytics")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@Autowired
	CountryService countryService;

	@PostMapping("/customer")
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}

	@GetMapping("/customer")
	@CrossOrigin
	public List<Customer> showCustomer() {
		return customerService.showCustomer();
	}
}
