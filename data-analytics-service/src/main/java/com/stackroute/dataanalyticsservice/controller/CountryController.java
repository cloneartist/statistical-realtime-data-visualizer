package com.stackroute.dataanalyticsservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.dataanalyticsservice.entity.Country;
import com.stackroute.dataanalyticsservice.entity.NameAndCredit;
import com.stackroute.dataanalyticsservice.entity.NameAndCustomers;
import com.stackroute.dataanalyticsservice.entity.NameAndSalary;
import com.stackroute.dataanalyticsservice.service.CountryService;

@RestController
public class CountryController {
	
	@Autowired
	CountryService countryService;
	
	@GetMapping("/country_vs_customers")
	@CrossOrigin
	public List<NameAndCustomers> numberOfCustomers(){
		return countryService.getNumberOfCustomers();
	}
	
	@GetMapping("/country_vs_credit")
	@CrossOrigin
	public List<NameAndCredit> averageOfCreditScore(){
		return countryService.getAverageOfCreditScore();
	}
	
	@GetMapping("/country_vs_salary")
	@CrossOrigin
	public List<NameAndSalary> averageOfSalary(){
		return countryService.getAverageOfSalary();
	}
}
