package com.example.practitionnersnote.service;

import com.example.practitionnersnote.model.PatientHistory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest

class PatientHistoryServiceTest {
    @Autowired
    private PatientHistoryService patientHistoryService;

    @Test
    void findAllPatientHistory() {
        //on vérife que la taille de la liste >0
     PatientHistory patientHistory = new PatientHistory();
     patientHistory.setE("Patient: TestNone Practitioner's notes/recommendations: Patient is smocker");
     patientHistoryService.save(patientHistory);
     List<PatientHistory> listResult = patientHistoryService.findAllPatientHistory();
     Assert.assertTrue(listResult.size() > 0);
    }

    @Test
    void findById() {
        PatientHistory patientHistory = new PatientHistory();
        patientHistory.setE("Patient: TestNone Practitioner's notes/recommendations: Patient is smocker");
        patientHistoryService.save(patientHistory);
        Long id = patientHistory.getId();
        patientHistoryService.findById(id);
        Assert.assertNotNull(patientHistory.getId());
        Assert.assertEquals(patientHistory.getE(),"Patient: TestNone Practitioner's notes/recommendations: Patient is smocker",
                "Patient: TestNone Practitioner's notes/recommendations: Patient is smocker");

    }

    @Test
    void findAllByPatId() {
        //On enregistre deux fiches de notes pour un même patient càd même patId et on vérifie que la taille de la liste des notes pour ce patient= 2
        //CLEAR
      patientHistoryService.deleteAll();
     PatientHistory patientHistory1 = new PatientHistory(2l,"Patient: TestNone Practitioner's notes/recommendations: Patient is smocker");
     PatientHistory patientHistory2 = new PatientHistory(2l,"Patient: TestNone Practitioner's notes/recommendations: Patient is fat");
     patientHistoryService.save(patientHistory1);
     patientHistoryService.save(patientHistory2);
     List<PatientHistory> listpatHistory = patientHistoryService.findAllByPatId(2l);
     Assert.assertTrue(listpatHistory.size() == 2);
    }

    @Test
    void save() {
        //on vérifie que l'identifiant de patient est non null
     PatientHistory patientHistory = new PatientHistory();
     patientHistory.setE("Patient: TestNone Practitioner's notes/recommendations: Patient is smocker");
     patientHistoryService.save(patientHistory);
     patientHistory = patientHistoryService.findById(patientHistory.getId());
     Assert.assertNotNull(patientHistory.getId());
     Assert.assertEquals(patientHistory.getE(), "Patient: TestNone Practitioner's notes/recommendations: Patient is smocker",
                    "Patient: TestNone Practitioner's notes/recommendations: Patient is smocker");
    }

    @Test
    void update() {
        //on modifie un paramétre et on vérifie qu'il va remplacer l'ancien paramétre
     PatientHistory patientHistory = new PatientHistory();
     patientHistory.setId(1l);
     patientHistory.setE("Patient: TestNone Practitioner's notes/recommendations: Patient is smocker");
     patientHistoryService.save(patientHistory);
     patientHistoryService.update(patientHistory,1l);
     patientHistory.setE("Patient: TestNone Practitioner's notes/recommendations: Patient is smocker update");
     patientHistoryService.save(patientHistory);
     Assert.assertEquals(patientHistory.getE(), "Patient: TestNone Practitioner's notes/recommendations: Patient is smocker update",
                    "Patient: TestNone Practitioner's notes/recommendations: Patient is smocker update");
    }

    @Test
    void deleteById() {
        // on supprime patientHistory et on vérifie qu'il n'est présent en bDD
      PatientHistory patientHistory = new PatientHistory();
      patientHistory.setE("Patient: TestNone Practitioner's notes/recommendations: Patient is smocker");
      Long id = patientHistory.getId();
      patientHistoryService.deleteById(id);
      assertThrows(IllegalArgumentException.class , () -> patientHistoryService.findById(id));
    }

}
