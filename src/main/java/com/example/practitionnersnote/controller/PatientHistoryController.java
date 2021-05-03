package com.example.practitionnersnote.controller;

import com.example.practitionnersnote.model.PatientHistory;
import com.example.practitionnersnote.service.PatientHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/patHistory")
public class PatientHistoryController {

    @Autowired
    PatientHistoryService patientHistoryService;

    @GetMapping
    public List<PatientHistory> getAllPatientHistory(){
        return patientHistoryService.findAllPatientHistory();
    }
    @GetMapping("/{id}")

    public PatientHistory findById(@PathVariable Long id) {
        return patientHistoryService.findById(id);
    }

    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public PatientHistory save(PatientHistory patientHistory) {
        return patientHistoryService.save(patientHistory);
    }

    @PostMapping(path ="/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public PatientHistory saveJson(@RequestBody PatientHistory patientHistory){
        return patientHistoryService.save(patientHistory);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody PatientHistory patientHistory, @PathVariable Long id){
      patientHistoryService.update(patientHistory,id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        patientHistoryService.deleteById(id);
    }

}
