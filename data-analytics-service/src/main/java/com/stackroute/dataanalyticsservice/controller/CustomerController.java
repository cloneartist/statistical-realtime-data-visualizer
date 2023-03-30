package com.stackroute.dataanalyticsservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.dataanalyticsservice.exceptions.CustomerAlreadyExistException;
import com.stackroute.dataanalyticsservice.model.Customer;
import com.stackroute.dataanalyticsservice.service.CountryService;
import com.stackroute.dataanalyticsservice.service.CustomerService;

//This CustomerController provides APIs to send data from customer table
@RestController
@RequestMapping("/analytics")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@Autowired
	CountryService countryService;
	
	
	//Used for testing purpose only(kafka will be used in real time)
	//An API to create data in the customer table
	@PostMapping("/customer")
	public Customer saveCustomer(@RequestBody Customer customer) {
		Customer responseCustomer=new Customer();
		try {
			responseCustomer=customerService.saveCustomer(customer);
		}catch(CustomerAlreadyExistException e){
			System.out.println(e);
		}catch(Exception e) {
			System.out.println(e);
		}
		return responseCustomer;
		
	}
	
	//An API to show the customer data in the home page in frontend
	@GetMapping("/customer")
	@CrossOrigin
	public List<Customer> showCustomer() {
		return customerService.showCustomer();
	}

	@GetMapping("/deleteCustomer")
	@CrossOrigin
	public void deleteCustomer() {
		customerService.deleteCustomers();
	}
}
