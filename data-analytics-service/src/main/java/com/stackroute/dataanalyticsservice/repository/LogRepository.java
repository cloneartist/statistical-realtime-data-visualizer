package com.stackroute.dataanalyticsservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.dataanalyticsservice.model.AnalyticsServiceLog;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface LogRepository extends JpaRepository<AnalyticsServiceLog, String> {

}
