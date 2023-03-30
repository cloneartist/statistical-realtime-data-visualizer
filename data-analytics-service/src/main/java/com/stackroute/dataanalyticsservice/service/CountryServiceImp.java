package com.stackroute.dataanalyticsservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.dataanalyticsservice.model.Country;
import com.stackroute.dataanalyticsservice.model.NameAndCredit;
import com.stackroute.dataanalyticsservice.model.NameAndCustomers;
import com.stackroute.dataanalyticsservice.model.NameAndSalary;
import com.stackroute.dataanalyticsservice.repository.CountryRepository;
import com.stackroute.dataanalyticsservice.repository.CustomerRepository;

@Service
public class CountryServiceImp implements CountryService {

	@Autowired
	CountryRepository countryRepository;

	@Autowired
	CustomerRepository customerRepository;

	
	// In this method if given country already exist in the country table we
	// aggregate country data which means increase the average of
	// credit score and average salary of that country and increase the number of customers
	// of that country by  1,
	
	// In the case if customer is from the new country we add the data of the
	// country to the country table
	@Override
	public void AggregateCountryDataOrAddCountry(String countryName, int creditScore, double salary) {

		Optional<Country> op = countryRepository.findByName(countryName);
		
		// checking whether that country mentioned in the customer already exist in the
		// country repository
		if (op.isPresent()) {
			Country country = op.get();
			// adding 1 to the existing number of customers in that country
			country.setNumberOfCustomers(country.getNumberOfCustomers() + 1);
			// updating the average of the credit score by adding the new credit score of
			// new customer
			country.setAverageCreditScore(
					(((double) country.getAverageCreditScore() * ((double) country.getNumberOfCustomers() - 1))+ creditScore) / ((double) country.getNumberOfCustomers()));
			// updating the average of the salary by adding the new credit score of new
			// customer
			country.setAverageSalary(
					(((double) country.getAverageSalary() * ((double) country.getNumberOfCustomers() - 1)) + salary)/ (double) country.getNumberOfCustomers());
			countryRepository.save(country);

		} else {

			// if the country is new then we will create new country in the country
			// repository
			Country new_country = new Country(countryName, 1, creditScore, salary);
			countryRepository.save(new_country);

		}

	}

	
	//fetches country name,number of customers from country table 
	@Override
	public List<NameAndCustomers> getNumberOfCustomers() {
		return countryRepository.findAllNameAndCustomers();
	}

	//fetches country name,average credit score from country table
	@Override
	public List<NameAndCredit> getAverageOfCreditScore() {
		return countryRepository.findAllNameAndCreditScore();
	}

	//fetches country name,average salary from country table
	@Override
	public List<NameAndSalary> getAverageOfSalary() {
		return countryRepository.findAllNameAndSalary();
	}

	@Override
	public void deleteCountry() {
		countryRepository.deleteAll();
	}


}
