package com.app.hospitalbilling.repository;

import com.app.hospitalbilling.model.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for accessing Diagnosis entities.
 */
@Repository
public interface DiagnosisRepository extends JpaRepository<Diagnosis, Integer> {
}
