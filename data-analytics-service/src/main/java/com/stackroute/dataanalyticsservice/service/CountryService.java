package com.stackroute.dataanalyticsservice.service;

import java.util.List;

import com.stackroute.dataanalyticsservice.model.Customer;
import com.stackroute.dataanalyticsservice.model.NameAndCredit;
import com.stackroute.dataanalyticsservice.model.NameAndCustomers;
import com.stackroute.dataanalyticsservice.model.NameAndSalary;

public interface CountryService {

	void addcountry(Customer customer);

	List<NameAndCustomers> getNumberOfCustomers();

	List<NameAndCredit> getAverageOfCreditScore();

	List<NameAndSalary> getAverageOfSalary();

}
