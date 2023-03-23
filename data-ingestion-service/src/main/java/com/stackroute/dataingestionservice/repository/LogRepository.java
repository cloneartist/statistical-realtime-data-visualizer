package com.stackroute.dataingestionservice.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.dataingestionservice.model.IngestionServiceLog;

@Repository
public interface LogRepository extends ReactiveCrudRepository<IngestionServiceLog, String> {
}
