package com.example.hospitalbilling;
import com.example.hospitalbilling.controller.BillingController;
import com.example.hospitalbilling.model.Diagnosis;
import com.example.hospitalbilling.model.Physician;
import com.example.hospitalbilling.model.Treatment;
import com.example.hospitalbilling.service.BillingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BillingControllerTests {

    @Mock
    private BillingService billingService;

    @InjectMocks
    private BillingController billingController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAllDiagnoses() {
        Diagnosis diagnosis1 = new Diagnosis(1, "Diagnosis 1", 100.0);
        Diagnosis diagnosis2 = new Diagnosis(2, "Diagnosis 2", 150.0);
        List<Diagnosis> diagnoses = Arrays.asList(diagnosis1, diagnosis2);

        when(billingService.getAllDiagnoses()).thenReturn(diagnoses);

        ResponseEntity<List<Diagnosis>> response = billingController.getAllDiagnoses();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(diagnoses, response.getBody());
    }

    @Test
    public void testGetDiagnosisById() {
        Diagnosis diagnosis = new Diagnosis(1, "Diagnosis 1", 100.0);

        when(billingService.getDiagnosisById(1)).thenReturn(diagnosis);

        ResponseEntity<Diagnosis> response = billingController.getDiagnosisById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(diagnosis, response.getBody());
    }

    @Test
    public void testGetAllPhysicians() {
        Physician physician1 = new Physician(1, "Physician 1", "Specialty 1");
        Physician physician2 = new Physician(2, "Physician 2", "Specialty 2");
        List<Physician> physicians = Arrays.asList(physician1, physician2);

        when(billingService.getAllPhysicians()).thenReturn(physicians);

        ResponseEntity<List<Physician>> response = billingController.getAllPhysicians();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(physicians, response.getBody());
    }

    @Test
    public void testGetPhysicianById() {
        Physician physician = new Physician(1, "Physician 1", "Specialty 1");

        when(billingService.getPhysicianById(1)).thenReturn(physician);

        ResponseEntity<Physician> response = billingController.getPhysicianById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(physician, response.getBody());
    }

    @Test
    public void testGetAllTreatmentsByDiagnosisId() {
        Treatment treatment1 = new Treatment(1, "Treatment 1", 50.0, 1);
        Treatment treatment2 = new Treatment(2, "Treatment 2", 75.0, 1);
        List<Treatment> treatments = Arrays.asList(treatment1, treatment2);

        when(billingService.getAllTreatmentsByDiagnosisId(1)).thenReturn(treatments);

        ResponseEntity<List<Treatment>> response = billingController.getAllTreatmentsByDiagnosisId(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(treatments, response.getBody());
    }

    @Test
    public void testGetTreatmentById() {
        Treatment treatment = new Treatment(1, "Treatment 1", 50.0, 1);

        when(billingService.getTreatmentById(1)).thenReturn(treatment);

        ResponseEntity<Treatment> response = billingController.getTreatmentById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(treatment, response.getBody());
    }

    @Test
    public void testCreateDiagnosis() {
        Diagnosis diagnosis = new Diagnosis(1, "Diagnosis 1", 100.0);

        when(billingService.saveDiagnosis(diagnosis)).thenReturn(diagnosis);

        ResponseEntity<Diagnosis> response = billingController.createDiagnosis(diagnosis);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(diagnosis, response.getBody());
    }

    @Test
    public void testCreatePhysician() {
        Physician physician = new Physician(1, "Physician 1", "Specialty 1");

        when(billingService.savePhysician(physician)).thenReturn(physician);

        ResponseEntity<Physician> response = billingController.createPhysician(physician);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(physician, response.getBody());
    }

    @Test
    public void testCreateTreatment() {
        Treatment treatment = new Treatment(1, "Treatment 1", 50.0, 1);

        when(billingService.saveTreatment(treatment)).thenReturn(treatment);

        ResponseEntity<Treatment> response = billingController.createTreatment(treatment);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(treatment, response.getBody());
    }

    @Test
    public void testUpdateDiagnosis() {
        Diagnosis updatedDiagnosis = new Diagnosis(1, "Updated Diagnosis", 150.0);

        when(billingService.saveDiagnosis(updatedDiagnosis)).thenReturn(updatedDiagnosis);

        ResponseEntity<Diagnosis> response = billingController.updateDiagnosis(1, updatedDiagnosis);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedDiagnosis, response.getBody());
    }

    @Test
    public void testUpdatePhysician() {
        Physician updatedPhysician = new Physician(1, "Updated Physician", "Specialty 1");

        when(billingService.savePhysician(updatedPhysician)).thenReturn(updatedPhysician);

        ResponseEntity<Physician> response = billingController.updatePhysician(1, updatedPhysician);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedPhysician, response.getBody());
    }

    @Test
    public void testUpdateTreatment() {
        Treatment updatedTreatment = new Treatment(1, "Updated Treatment", 75.0, 1);

        when(billingService.saveTreatment(updatedTreatment)).thenReturn(updatedTreatment);

        ResponseEntity<Treatment> response = billingController.updateTreatment(1, updatedTreatment);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedTreatment, response.getBody());
    }

    @Test
    public void testDeleteDiagnosis() {
        ResponseEntity<Void> response = billingController.deleteDiagnosis(1);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(billingService, times(1)).deleteDiagnosis(1);
    }

    @Test
    public void testDeletePhysician() {
        ResponseEntity<Void> response = billingController.deletePhysician(1);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(billingService, times(1)).deletePhysician(1);
    }

    @Test
    public void testDeleteTreatment() {
        ResponseEntity<Void> response = billingController.deleteTreatment(1);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(billingService, times(1)).deleteTreatment(1);
    }
}
