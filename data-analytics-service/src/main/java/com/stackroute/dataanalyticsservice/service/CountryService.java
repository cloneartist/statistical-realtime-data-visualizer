package com.stackroute.dataanalyticsservice.service;

import java.util.List;

import com.stackroute.dataanalyticsservice.entity.Country;
import com.stackroute.dataanalyticsservice.entity.Customer;
import com.stackroute.dataanalyticsservice.entity.NameAndCredit;
import com.stackroute.dataanalyticsservice.entity.NameAndCustomers;
import com.stackroute.dataanalyticsservice.entity.NameAndSalary;

public interface CountryService {

	void addcountry(Customer customer);

	List<NameAndCustomers> getNumberOfCustomers();

	List<NameAndCredit> getAverageOfCreditScore();

	List<NameAndSalary> getAverageOfSalary();

}
