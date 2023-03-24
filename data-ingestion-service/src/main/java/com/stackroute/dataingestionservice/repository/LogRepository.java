package com.stackroute.dataingestionservice.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.dataingestionservice.model.IngestionServiceLog;

@Repository
public interface LogRepository extends R2dbcRepository<IngestionServiceLog, String> {
}
