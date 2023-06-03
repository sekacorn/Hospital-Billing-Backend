package com.example.hospitalbilling.controller;

import com.example.hospitalbilling.model.Diagnosis;
import com.example.hospitalbilling.model.Physician;
import com.example.hospitalbilling.model.Treatment;
import com.example.hospitalbilling.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BillingController {

    private final BillingService billingService;

    @Autowired
    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    @GetMapping("/diagnoses")
    public ResponseEntity<List<Diagnosis>> getAllDiagnoses() {
        List<Diagnosis> diagnoses = billingService.getAllDiagnoses();
        return new ResponseEntity<>(diagnoses, HttpStatus.OK);
    }

    @GetMapping("/diagnoses/{id}")
    public ResponseEntity<Diagnosis> getDiagnosisById(@PathVariable int id) {
        Diagnosis diagnosis = billingService.getDiagnosisById(id);
        return new ResponseEntity<>(diagnosis, HttpStatus.OK);
    }

    @GetMapping("/physicians")
    public ResponseEntity<List<Physician>> getAllPhysicians() {
        List<Physician> physicians = billingService.getAllPhysicians();
        return new ResponseEntity<>(physicians, HttpStatus.OK);
    }

    @GetMapping("/physicians/{id}")
    public ResponseEntity<Physician> getPhysicianById(@PathVariable int id) {
        Physician physician = billingService.getPhysicianById(id);
        return new ResponseEntity<>(physician, HttpStatus.OK);
    }

    @GetMapping("/diagnoses/{diagnosisId}/treatments")
    public ResponseEntity<List<Treatment>> getAllTreatmentsByDiagnosisId(@PathVariable int diagnosisId) {
        List<Treatment> treatments = billingService.getAllTreatmentsByDiagnosisId(diagnosisId);
        return new ResponseEntity<>(treatments, HttpStatus.OK);
    }

    @GetMapping("/treatments/{id}")
    public ResponseEntity<Treatment> getTreatmentById(@PathVariable int id) {
        Treatment treatment = billingService.getTreatmentById(id);
        return new ResponseEntity<>(treatment, HttpStatus.OK);
    }

    @PostMapping("/diagnoses")
    public ResponseEntity<Diagnosis> createDiagnosis(@RequestBody Diagnosis diagnosis) {
        Diagnosis savedDiagnosis = billingService.saveDiagnosis(diagnosis);
        return new ResponseEntity<>(savedDiagnosis, HttpStatus.CREATED);
    }

    @PostMapping("/physicians")
    public ResponseEntity<Physician> createPhysician(@RequestBody Physician physician) {
        Physician savedPhysician = billingService.savePhysician(physician);
        return new ResponseEntity<>(savedPhysician, HttpStatus.CREATED);
    }

    @PostMapping("/treatments")
    public ResponseEntity<Treatment> createTreatment(@RequestBody Treatment treatment) {
        Treatment savedTreatment = billingService.saveTreatment(treatment);
        return new ResponseEntity<>(savedTreatment, HttpStatus.CREATED);
    }

    @PutMapping("/diagnoses/{id}")
    public ResponseEntity<Diagnosis> updateDiagnosis(@PathVariable int id, @RequestBody Diagnosis diagnosis) {
        Diagnosis updatedDiagnosis = billingService.saveDiagnosis(diagnosis);
        return new ResponseEntity<>(updatedDiagnosis, HttpStatus.OK);
    }

    @PutMapping("/physicians/{id}")
    public ResponseEntity<Physician> updatePhysician(@PathVariable int id, @RequestBody Physician physician) {
        Physician updatedPhysician = billingService.savePhysician(physician);
        return new ResponseEntity<>(updatedPhysician, HttpStatus.OK);
    }

    @PutMapping("/treatments/{id}")
    public ResponseEntity<Treatment> updateTreatment(@PathVariable int id, @RequestBody Treatment treatment) {
        Treatment updatedTreatment = billingService.saveTreatment(treatment);
        return new ResponseEntity<>(updatedTreatment, HttpStatus.OK);
    }

    @DeleteMapping("/diagnoses/{id}")
    public ResponseEntity<Void> deleteDiagnosis(@PathVariable int id) {
        billingService.deleteDiagnosis(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/physicians/{id}")
    public ResponseEntity<Void> deletePhysician(@PathVariable int id) {
        billingService.deletePhysician(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/treatments/{id}")
    public ResponseEntity<Void> deleteTreatment(@PathVariable int id) {
        billingService.deleteTreatment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

