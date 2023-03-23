package com.stackroute.dataanalyticsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.dataanalyticsservice.model.BankRecieveModel;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface BankRepository extends JpaRepository<BankRecieveModel, String> {

}
