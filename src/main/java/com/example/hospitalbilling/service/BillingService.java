package com.example.hospitalbilling.service;

import com.example.hospitalbilling.model.Diagnosis;
import com.example.hospitalbilling.model.Physician;
import com.example.hospitalbilling.model.Treatment;
import com.example.hospitalbilling.repository.DiagnosisRepository;
import com.example.hospitalbilling.repository.PhysicianRepository;
import com.example.hospitalbilling.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingService {

    private final DiagnosisRepository diagnosisRepository;
    private final PhysicianRepository physicianRepository;
    private final TreatmentRepository treatmentRepository;

    @Autowired
    public BillingService(DiagnosisRepository diagnosisRepository, PhysicianRepository physicianRepository, TreatmentRepository treatmentRepository) {
        this.diagnosisRepository = diagnosisRepository;
        this.physicianRepository = physicianRepository;
        this.treatmentRepository = treatmentRepository;
    }

    public List<Diagnosis> getAllDiagnoses() {
        return diagnosisRepository.findAll();
    }

    public Diagnosis getDiagnosisById(int id) {
        return diagnosisRepository.findById(id).orElse(null);
    }

    public List<Physician> getAllPhysicians() {
        return physicianRepository.findAll();
    }

    public Physician getPhysicianById(int id) {
        return physicianRepository.findById(id).orElse(null);
    }

    public List<Treatment> getAllTreatmentsByDiagnosisId(int diagnosisId) {
        return treatmentRepository.findAllByDiagnosisId(diagnosisId);
    }

    public Treatment getTreatmentById(int id) {
        return treatmentRepository.findById(id).orElse(null);
    }

    public Diagnosis saveDiagnosis(Diagnosis diagnosis) {
        return diagnosisRepository.save(diagnosis);
    }

    public Physician savePhysician(Physician physician) {
        return physicianRepository.save(physician);
    }

    public Treatment saveTreatment(Treatment treatment) {
        return treatmentRepository.save(treatment);
    }

    public void deleteDiagnosis(int id) {
        diagnosisRepository.deleteById(id);
    }

    public void deletePhysician(int id) {
        physicianRepository.deleteById(id);
    }

    public void deleteTreatment(int id) {
        treatmentRepository.deleteById(id);
    }
}
