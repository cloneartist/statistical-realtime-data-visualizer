package com.stackroute.dataanalyticsservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stackroute.dataanalyticsservice.model.Country;
import com.stackroute.dataanalyticsservice.model.NameAndCredit;
import com.stackroute.dataanalyticsservice.model.NameAndCustomers;
import com.stackroute.dataanalyticsservice.model.NameAndSalary;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

	Optional<Country> findByName(String country);
	
	//used for fetching data of country name,number of customers
	@Query("SELECT new com.stackroute.dataanalyticsservice.model.NameAndCustomers(c.name,c.numberOfCustomers) FROM Country c")
	List<NameAndCustomers> findAllNameAndCustomers();

	//used for fetching data of country name,average credit score
	@Query("SELECT new com.stackroute.dataanalyticsservice.model.NameAndCredit(c.name,c.averageCreditScore) FROM Country c")
	List<NameAndCredit> findAllNameAndCreditScore();

	//used for fetching data of country name,average salary
	@Query("SELECT new com.stackroute.dataanalyticsservice.model.NameAndSalary(c.name,c.averageSalary) FROM Country c")
	List<NameAndSalary> findAllNameAndSalary();

}
