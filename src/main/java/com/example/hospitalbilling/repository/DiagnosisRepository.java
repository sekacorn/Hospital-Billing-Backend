package com.example.hospitalbilling.repository;
import com.example.hospitalbilling.model.Diagnosis;
import com.example.hospitalbilling.model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiagnosisRepository extends JpaRepository<Diagnosis, Integer> {
    List<Treatment> findByDiagnosisId(int diagnosisId);

}
