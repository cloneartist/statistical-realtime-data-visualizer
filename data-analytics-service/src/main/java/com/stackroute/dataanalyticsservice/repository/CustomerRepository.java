package com.stackroute.dataanalyticsservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.dataanalyticsservice.entity.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

//	Optional<List<Customer>> findById(int customer_id);
	
}
