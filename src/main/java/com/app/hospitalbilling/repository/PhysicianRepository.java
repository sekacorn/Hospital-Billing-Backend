package com.app.hospitalbilling.repository;

import com.app.hospitalbilling.model.Physician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for accessing Physician entities.
 */
@Repository
public interface PhysicianRepository extends JpaRepository<Physician, Integer> {
    
    /**
     * Finds a physician by their ID.
     *
     * @param physicianId the ID of the physician
     * @return an Optional containing the physician, or empty if not found
     */
    Optional<Physician> findById(int physicianId);
}
