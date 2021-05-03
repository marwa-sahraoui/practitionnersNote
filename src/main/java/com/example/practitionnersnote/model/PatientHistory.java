package com.example.practitionnersnote.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="patientHistory")
public class PatientHistory {
    @Id
    private Long patId;
    private String e;

    public PatientHistory() {
        //
    }

    public PatientHistory(Long patId, String e) {
        this.patId = patId;
        this.e = e;
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
