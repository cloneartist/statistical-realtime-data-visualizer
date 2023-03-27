package com.stackroute.dataanalyticsservice.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.dataanalyticsservice.entity.Country;
import com.stackroute.dataanalyticsservice.entity.Customer;
import com.stackroute.dataanalyticsservice.entity.NameAndCredit;
import com.stackroute.dataanalyticsservice.entity.NameAndCustomers;
import com.stackroute.dataanalyticsservice.entity.NameAndSalary;
import com.stackroute.dataanalyticsservice.repository.CountryRepository;
import com.stackroute.dataanalyticsservice.repository.CustomerRepository;

@Service
public class CountryServiceImp implements CountryService{
	
	@Autowired
	CountryRepository countryRepository;
	
	
	@Autowired
	CustomerRepository customerRepository;
	
	
	//In this method if given country already exist in the country table we aggregate country data which means increase the average of
	//credit score and salary of that country and increase the number of customers of that country ,
	//In the case if customer is from the new country we add the data of the country to the country table
	@Override
	public void AggregateCountryDataOrAddCountry(String countryName,int creditScore,double salary) {

		Optional<Country> op=countryRepository.findByName(countryName);
		//checking whether that country mentioned in the customer already exist in the country repository
		
		
		if(op.isPresent()) {
			Country country=op.get();
			//adding 1 to the existing number of customers in that country
			country.setNumberOfCustomers(country.getNumberOfCustomers() +1); 
			//updating the average of the credit score by adding the new credit score of new customer
			country.setAverageCreditScore((((double)country.getAverageCreditScore()*((double)country.getNumberOfCustomers()-1))+creditScore)/((double)country.getNumberOfCustomers()));
			//updating the average of the salary by adding the new credit score of new customer
			country.setAverageSalary((((double)country.getAverageSalary()*((double)country.getNumberOfCustomers()-1))+salary)/(double)country.getNumberOfCustomers());
			
			
		}else {

			//if the country is new then we will create new country in the country repository
			Country new_country=new Country(countryName,1,creditScore,salary);
			countryRepository.save(new_country);
			
		}
		
		
	}

	@Override
	public List<NameAndCustomers> getNumberOfCustomers() {
		
		return countryRepository.findAllNameAndCustomers();
	}

	@Override
	public List<NameAndCredit> getAverageOfCreditScore() {
		return countryRepository.findAllNameAndCreditScore();
	}

	@Override
	public List<NameAndSalary> getAverageOfSalary() {
		return countryRepository.findAllNameAndSalary();
	}

	

	
	
}
