package com.stackroute.dataanalyticsservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stackroute.dataanalyticsservice.entity.Country;
import com.stackroute.dataanalyticsservice.entity.NameAndCredit;
import com.stackroute.dataanalyticsservice.entity.NameAndCustomers;
import com.stackroute.dataanalyticsservice.entity.NameAndSalary;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {

	Optional<Country> findByName(String country);
	
	
	@Query("SELECT new com.stackroute.dataanalyticsservice.entity.NameAndCustomers(c.name,c.numberOfCustomers) FROM Country c")
	List<NameAndCustomers> findAllNameAndCustomers();

	@Query("SELECT new com.stackroute.dataanalyticsservice.entity.NameAndCredit(c.name,c.averageCreditScore) FROM Country c")
	List<NameAndCredit> findAllNameAndCreditScore();

	@Query("SELECT new com.stackroute.dataanalyticsservice.entity.NameAndSalary(c.name,c.averageSalary) FROM Country c")
	List<NameAndSalary> findAllNameAndSalary();
	
	
	

}
