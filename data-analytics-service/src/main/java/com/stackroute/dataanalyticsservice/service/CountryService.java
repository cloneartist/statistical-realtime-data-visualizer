package com.stackroute.dataanalyticsservice.service;

import java.util.List;

import com.stackroute.dataanalyticsservice.entity.Country;
import com.stackroute.dataanalyticsservice.entity.Customer;

public interface CountryService {

	void addcountry(Customer customer);

	List<Country> getNumberOfCustomers();

}
