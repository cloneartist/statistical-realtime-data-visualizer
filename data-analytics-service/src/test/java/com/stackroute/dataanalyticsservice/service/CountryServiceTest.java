package com.stackroute.dataanalyticsservice.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.stackroute.dataanalyticsservice.repository.CountryRepository;

class CountryServiceTest {
	
	@Mock
	CountryRepository countryReppository;
	
	@InjectMocks
	CountryServiceImp countryService;
	
	private 
	
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
