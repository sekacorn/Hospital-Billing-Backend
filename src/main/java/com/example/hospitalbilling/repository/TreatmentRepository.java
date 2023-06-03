package com.example.hospitalbilling.repository;

import com.example.hospitalbilling.model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Integer> {
    List<Treatment> findAllByDiagnosisId(int diagnosisId);
}
