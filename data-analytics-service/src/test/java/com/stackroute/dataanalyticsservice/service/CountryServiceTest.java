//package com.stackroute.dataanalyticsservice.service;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//
//import com.stackroute.dataanalyticsservice.model.Country;
//import com.stackroute.dataanalyticsservice.model.NameAndCredit;
//import com.stackroute.dataanalyticsservice.model.NameAndCustomers;
//import com.stackroute.dataanalyticsservice.model.NameAndSalary;
//import com.stackroute.dataanalyticsservice.repository.CountryRepository;
//
//import junit.framework.Assert;
//
//class CountryServiceTest {
//
//	@Mock
//	CountryRepository countryRepository;
//
//	@InjectMocks
//	CountryServiceImp countryService;
//
//	private Country country=new Country();
//
//	private NameAndCustomers nameAndCustomers=new NameAndCustomers();
//	private NameAndCredit nameAndCredit=new NameAndCredit();
//	private NameAndSalary nameAndSalary=new NameAndSalary();
//
//	private String countryName;
//	private int creditScore;
//	private double salary;
//
//
//	@BeforeEach
//	void setUp() throws Exception {
//
//		MockitoAnnotations.openMocks(this);
//
//		country.setName("India");
//		country.setNumberOfCustomers(1);
//		country.setAverageCreditScore(1.0);
//		country.setAverageSalary(1.2);
//
//		nameAndCustomers.setName(country.getName());
//		nameAndCustomers.setNumberOfCustomers(country.getNumberOfCustomers());
//
//		nameAndCredit.setName(country.getName());
//		nameAndCredit.setAverageCreditScore(country.getAverageCreditScore());
//
//		nameAndSalary.setName(country.getName());
//		nameAndSalary.setAverageSalary(country.getAverageSalary());
//
//		countryName=country.getName();
//		creditScore=(int)country.getAverageCreditScore();
//		salary=country.getAverageSalary();
//
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//
//		country=null;
//		nameAndCustomers=null;
//		nameAndCredit=null;
//		nameAndSalary=null;
//
//		countryName=null;
//		creditScore=0;
//		salary=0;
//
//	}
//
//	@Test
//	void testingGetNumberOfCustomers() {
//
//		List<NameAndCustomers> list=new ArrayList();
//		list.add(nameAndCustomers);
//
//		when(countryRepository.findAllNameAndCustomers()).thenReturn(list);
//		List<NameAndCustomers> responseList=countryService.getNumberOfCustomers();
//
//		Assert.assertEquals(list, responseList);
//	}
//
//	@Test
//	void testingGetAverageCreditScore() {
//
//		List<NameAndCredit> list=new ArrayList();
//		list.add(nameAndCredit);
//
//		when(countryRepository.findAllNameAndCreditScore()).thenReturn(list);
//		List<NameAndCredit> responseList=countryService.getAverageOfCreditScore();
//
//		Assert.assertEquals(list, responseList);
//	}
//
//	@Test
//	void testingGetAverageSalary() {
//
//		List<NameAndSalary> list=new ArrayList();
//		list.add(nameAndSalary);
//
//		when(countryRepository.findAllNameAndSalary()).thenReturn(list);
//		List<NameAndSalary> responseList=countryService.getAverageOfSalary();
//
//		Assert.assertEquals(list, responseList);
//	}
//
//	@Test
//	void testingAggregateCountryDataOrAddCountry() {
//		countryService.AggregateCountryDataOrAddCountry(countryName, creditScore, salary);
//		verify(countryRepository,times(1));
//
//	}
//
//}
