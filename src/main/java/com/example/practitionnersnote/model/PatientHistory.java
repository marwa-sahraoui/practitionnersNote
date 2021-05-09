package com.example.practitionnersnote.model;

import com.example.practitionnersnote.configuration.IdGenerator;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;

@Document(collection = "patientHistory")
public class PatientHistory {

    @Id
    private Long id; //patientHistory:fiche du patient ayant un id et un patId(patient correspondant)
    private Long patId;
    private String e;

    public PatientHistory() {
        id = IdGenerator.incrementAndGetValue(); //id  utilisé dans le constructeur
    }

    public PatientHistory(Long patId, String e) {
        id = IdGenerator.incrementAndGetValue();
        this.patId = patId;
        this.e = e;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatId() {
        return patId;
    }

    public void setPatId(Long patId) {
        this.patId = patId;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }
}
