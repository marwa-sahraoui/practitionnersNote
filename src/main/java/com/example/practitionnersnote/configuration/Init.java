package com.example.practitionnersnote.configuration;

import com.example.practitionnersnote.model.PatientHistory;
import com.example.practitionnersnote.repository.PatientHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
//insertion manuel d'un exemple du patientHistory pour vérifier sa présence dans la BDD
public class Init implements CommandLineRunner {

    @Autowired
    PatientHistoryRepository patientHistoryRepository;

    @Override
    public void run(String... args) throws Exception {
        if (patientHistoryRepository.count() == 0) {
            patientHistoryRepository.save(
                    new PatientHistory(1L, "Patient: marwa update Practitioner's notes/recommendations: " +
                            "Patient states that they are short term Smoker "));
        }
    }
}

