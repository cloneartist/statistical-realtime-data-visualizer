package com.stackroute.dataanalyticsservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.dataanalyticsservice.model.Country;
import com.stackroute.dataanalyticsservice.model.Customer;
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

	@Override
	public void addcountry(Customer customer) {

		if (this.customerRepository.findById(customer.getCustomer_id()).isPresent()) {
			return;
		}
		Optional<Country> op = countryRepository.findByName(customer.getCountry());
		// checking whether that country mentioned in the customer already exist in the
		// country repository
		if (op.isPresent()) {
			System.out.println("country  available");
			Country country = op.get();
			System.out.println(country);
			// adding 1 to the existing number of customers in that country
			country.setNumberOfCustomers(country.getNumberOfCustomers() + 1);
			// updating the average of the credit score by adding the new credit score of
			// new customer
			country.setAverageCreditScore(
					(((double) country.getAverageCreditScore() * ((double) country.getNumberOfCustomers() - 1))
							+ customer.getCredit_card()) / ((double) country.getNumberOfCustomers()));
			// updating the average of the salary by adding the new credit score of new
			// customer
			country.setAverageSalary(
					(((double) country.getAverageSalary() * ((double) country.getNumberOfCustomers() - 1))
							+ customer.getEstimated_salary()) / (double) country.getNumberOfCustomers());

		} else {

			// if the country is new then we will create new country in the country
			// repository
			Country new_country = new Country(customer.getCountry(), 1, (float) customer.getCredit_score(),
					customer.getEstimated_salary());
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
