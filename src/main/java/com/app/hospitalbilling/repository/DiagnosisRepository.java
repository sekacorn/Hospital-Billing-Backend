package com.app.hospitalbilling.repository;

import com.app.hospitalbilling.model.Diagnosis;
import com.app.hospitalbilling.model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for accessing Diagnosis entities.
 */
@Repository
public interface DiagnosisRepository extends JpaRepository<Diagnosis, Integer> {
    
    /**
     * Finds treatments associated with a given diagnosis ID.
     *
     * @param diagnosisId the ID of the diagnosis
     * @return a list of treatments related to the diagnosis
     */
    List<Treatment> findTreatmentsByDiagnosisId(int diagnosisId);
}
