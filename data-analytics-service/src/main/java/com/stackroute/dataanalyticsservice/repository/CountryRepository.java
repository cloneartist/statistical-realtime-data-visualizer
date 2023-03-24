package com.stackroute.dataanalyticsservice.repository;

import java.util.List;
import java.util.Optional;

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

	@Query("SELECT new com.stackroute.dataanalyticsservice.model.NameAndCustomers(c.name,c.numberOfCustomers) FROM Country c")
	List<NameAndCustomers> findAllNameAndCustomers();

	@Query("SELECT new com.stackroute.dataanalyticsservice.model.NameAndCredit(c.name,c.averageCreditScore) FROM Country c")
	List<NameAndCredit> findAllNameAndCreditScore();

	@Query("SELECT new com.stackroute.dataanalyticsservice.model.NameAndSalary(c.name,c.averageSalary) FROM Country c")
	List<NameAndSalary> findAllNameAndSalary();

}
