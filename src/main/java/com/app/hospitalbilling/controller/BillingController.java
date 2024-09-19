package com.app.hospitalbilling.controller;

import com.app.hospitalbilling.model.Diagnosis;
import com.app.hospitalbilling.model.Physician;
import com.app.hospitalbilling.model.Treatment;
import com.app.hospitalbilling.service.BillingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; // Add this import
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for handling billing-related API requests.
 */
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
        return ResponseEntity.ok(diagnoses);
    }

    @GetMapping("/diagnoses/{id}")
    public ResponseEntity<Diagnosis> getDiagnosisById(@PathVariable int id) {
        Diagnosis diagnosis = billingService.getDiagnosisById(id);
        return ResponseEntity.ok(diagnosis);
    }

    @GetMapping("/physicians")
    public ResponseEntity<List<Physician>> getAllPhysicians() {
        List<Physician> physicians = billingService.getAllPhysicians();
        return ResponseEntity.ok(physicians);
    }

    @GetMapping("/physicians/{id}")
    public ResponseEntity<Physician> getPhysicianById(@PathVariable int id) {
        Physician physician = billingService.getPhysicianById(id);
        return ResponseEntity.ok(physician);
    }

    @GetMapping("/diagnoses/{diagnosisId}/treatments")
    public ResponseEntity<List<Treatment>> getAllTreatmentsByDiagnosisId(@PathVariable int diagnosisId) {
        List<Treatment> treatments = billingService.getAllTreatmentsByDiagnosisId(diagnosisId);
        return ResponseEntity.ok(treatments);
    }

    @GetMapping("/treatments/{id}")
    public ResponseEntity<Treatment> getTreatmentById(@PathVariable int id) {
        Treatment treatment = billingService.getTreatmentById(id);
        return ResponseEntity.ok(treatment);
    }

    @PostMapping("/diagnoses")
    public ResponseEntity<Diagnosis> createDiagnosis(@RequestBody Diagnosis diagnosis) {
        Diagnosis savedDiagnosis = billingService.saveDiagnosis(diagnosis);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDiagnosis);
    }

    @PostMapping("/physicians")
    public ResponseEntity<Physician> createPhysician(@RequestBody Physician physician) {
        Physician savedPhysician = billingService.savePhysician(physician);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPhysician);
    }

    @PostMapping("/treatments")
    public ResponseEntity<Treatment> createTreatment(@RequestBody Treatment treatment) {
        Treatment savedTreatment = billingService.saveTreatment(treatment);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTreatment);
    }

    @PutMapping("/diagnoses/{id}")
    public ResponseEntity<Diagnosis> updateDiagnosis(@PathVariable int id, @RequestBody Diagnosis diagnosis) {
        Diagnosis updatedDiagnosis = billingService.saveDiagnosis(diagnosis);
        return ResponseEntity.ok(updatedDiagnosis);
    }

    @PutMapping("/physicians/{id}")
    public ResponseEntity<Physician> updatePhysician(@PathVariable int id, @RequestBody Physician physician) {
        Physician updatedPhysician = billingService.savePhysician(physician);
        return ResponseEntity.ok(updatedPhysician);
    }

    @PutMapping("/treatments/{id}")
    public ResponseEntity<Treatment> updateTreatment(@PathVariable int id, @RequestBody Treatment treatment) {
        Treatment updatedTreatment = billingService.saveTreatment(treatment);
        return ResponseEntity.ok(updatedTreatment);
    }

    @DeleteMapping("/diagnoses/{id}")
    public ResponseEntity<Void> deleteDiagnosis(@PathVariable int id) {
        billingService.deleteDiagnosis(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/physicians/{id}")
    public ResponseEntity<Void> deletePhysician(@PathVariable int id) {
        billingService.deletePhysician(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/treatments/{id}")
    public ResponseEntity<Void> deleteTreatment(@PathVariable int id) {
        billingService.deleteTreatment(id);
        return ResponseEntity.noContent().build();
    }
}
