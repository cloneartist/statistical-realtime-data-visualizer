package com.stackroute.dataanalyticsservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.dataanalyticsservice.model.Country;
import com.stackroute.dataanalyticsservice.model.NameAndCredit;
import com.stackroute.dataanalyticsservice.model.NameAndCustomers;
import com.stackroute.dataanalyticsservice.model.NameAndSalary;
import com.stackroute.dataanalyticsservice.service.CountryService;

@RestController
public class CountryController {
	
	@Autowired
	CountryService countryService;
	
	//An API which gives the data of total number of customer with respective to country from country table 
	@GetMapping("/country_vs_customers")
	@CrossOrigin
	public List<NameAndCustomers> numberOfCustomers(){
		return countryService.getNumberOfCustomers();
	}
	
	//An API which gives the data of total average of credit score with respective to country from country table 
	@GetMapping("/country_vs_credit")
	@CrossOrigin
	public List<NameAndCredit> averageOfCreditScore(){
		return countryService.getAverageOfCreditScore();
	}
	
	//An API which gives the data of total average of salary with respective to country from country table 
	@GetMapping("/country_vs_salary")
	@CrossOrigin
	public List<NameAndSalary> averageOfSalary(){
		return countryService.getAverageOfSalary();
	}
}
