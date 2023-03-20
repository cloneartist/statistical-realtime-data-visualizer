package com.stackroute.dataanalyticsservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stackroute.dataanalyticsservice.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {

	Optional<Country> findByName(String country);
	
	@Query("SELECT c.name,c.numberOfCustomers FROM Country c")
	List<Country> findAllByCountryAndNumberOfCustomers();

}
