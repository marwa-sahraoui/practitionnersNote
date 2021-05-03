package com.example.practitionnersnote.service;

import com.example.practitionnersnote.model.PatientHistory;
import com.example.practitionnersnote.repository.PatientHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientHistoryService {

    @Autowired
    PatientHistoryRepository patientHistoryRepository;

    public List<PatientHistory> findAllPatientHistory() {
        return patientHistoryRepository.findAll();
    }

    public PatientHistory findById(Long id) {
        return patientHistoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid patientHistory:" + id));
    }

    public PatientHistory save(PatientHistory patientHistory) {
        return patientHistoryRepository.save(patientHistory);
    }


    public void update(PatientHistory patientHistory, Long id) {
        Optional<PatientHistory> oldPatientHistoryOptional = patientHistoryRepository.findById(id);

        if (oldPatientHistoryOptional.isPresent()) {
            PatientHistory oldPatientHistory = oldPatientHistoryOptional.get();

            oldPatientHistory.setPatId(patientHistory.getPatId());
            oldPatientHistory.setE(patientHistory.getE());
            patientHistoryRepository.save(patientHistory);
        } else {
            throw new IllegalStateException("Patient history not found !!!!!");
        }
    }


    public void deleteById(Long id) {
        patientHistoryRepository.deleteById(id);
    }
}
