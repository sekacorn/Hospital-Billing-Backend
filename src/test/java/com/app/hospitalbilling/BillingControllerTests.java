package com.app.hospitalbilling;

import com.app.hospitalbilling.model.Diagnosis;
import com.app.hospitalbilling.service.BillingService;
import com.app.hospitalbilling.controller.BillingController;
import org.junit.jupiter.api.BeforeEach; // Import this
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations; // Import this
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

    @BeforeEach // Add this method to initialize mocks
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllDiagnoses() {
        Diagnosis diagnosis1 = new Diagnosis("Headache", 50.00);
        Diagnosis diagnosis2 = new Diagnosis("Fever", 40.00);
        List<Diagnosis> diagnoses = Arrays.asList(diagnosis1, diagnosis2);
        
        when(billingService.getAllDiagnoses()).thenReturn(diagnoses);
        
        ResponseEntity<List<Diagnosis>> response = billingController.getAllDiagnoses();
        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
        verify(billingService, times(1)).getAllDiagnoses();
    }

    @Test
    public void testCreateDiagnosis() {
        Diagnosis diagnosis = new Diagnosis("Fracture", 150.00);
        when(billingService.saveDiagnosis(diagnosis)).thenReturn(diagnosis);

        ResponseEntity<Diagnosis> response = billingController.createDiagnosis(diagnosis);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(diagnosis, response.getBody());
        verify(billingService, times(1)).saveDiagnosis(diagnosis);
    }
}
