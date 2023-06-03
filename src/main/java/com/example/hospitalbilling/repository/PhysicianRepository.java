package com.example.hospitalbilling.repository;

import com.example.hospitalbilling.model.Physician;
import com.example.hospitalbilling.model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhysicianRepository extends JpaRepository<Physician, Integer> {
    List<Physician> findByPhysicianId(int physicianId);
}
