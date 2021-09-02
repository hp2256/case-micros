package com.hp.ownerservice.repos;

import com.hp.ownerservice.models.report.Report;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.Date;

public interface ReportsDao extends MongoRepository<Report, String> {
}
