package com.example.practitionnersnote.repository;

import com.example.practitionnersnote.model.PatientHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientHistoryRepository extends MongoRepository<PatientHistory,Long> {
}
