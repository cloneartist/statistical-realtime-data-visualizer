package com.stackroute.dataanalyticsservice.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.stackroute.dataanalyticsservice.model.Customer;
import com.stackroute.dataanalyticsservice.repository.CountryRepository;
import com.stackroute.dataanalyticsservice.repository.CustomerRepository;

import junit.framework.Assert;



class CustomerServiceTest {

	
	@Mock
	CustomerRepository customerRepository;
	
	@Mock
	CountryRepository countryRepository;
	
	@Mock
	CountryServiceImp countryService; 
	
	@InjectMocks
	CustomerServiceImp customerService;
	
	private Customer customer=new Customer();
	
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		//Customer customer=new Customer();
		customer.setCustomer_id(1000000L);
		customer.setCredit_score(123);
		customer.setCountry("India");
		customer.setAge(20);
		customer.setBalance(100);
		customer.setCredit_card(100);
		customer.setEstimated_salary(100.0);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		customer=null;
	}

	@Test
	void testingSaveCustomer() {
		Mockito.when(customerRepository.save(customer)).thenReturn(customer);
		Customer responseCustomer=customerService.saveCustomer(customer);
		Assert.assertEquals(customer,responseCustomer);
	}
	
	@Test
	void testingShowCustomer() {
		List<Customer> customerList=new ArrayList();
		customerList.add(customer);
		Mockito.when(customerRepository.findAll()).thenReturn(customerList);
		List<Customer> responseCustomerList=customerService.showCustomer();
		Assert.assertEquals(customerList,responseCustomerList);
		
	}
	
	

}




