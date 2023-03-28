package com.stackroute.dataanalyticsservice.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.stackroute.dataanalyticsservice.model.Country;
import com.stackroute.dataanalyticsservice.repository.CountryRepository;

class CountryServiceTest {
	
	@Mock
	CountryRepository countryReppository;
	
	@InjectMocks
	CountryServiceImp countryService;
	
	private Country country=new Country();
	
	@BeforeEach
	void setUp() throws Exception {
		
		country.setName("India");
		country.setNumberOfCustomers(123);
		country.setAverageCreditScore(1.1);
		country.setAverageSalary(1.2);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		country=null;
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
