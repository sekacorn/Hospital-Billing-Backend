package com.app.hospitalbilling.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

/**
 * Entity class representing a Treatment in the hospital billing system.
 * This class maps to the 'treatment' table in the database.
 *
 * A treatment includes name, description, cost, duration, and is associated
 * with a specific diagnosis.
 */
@Entity
@Table(name = "treatment")
public class Treatment {

    /**
     * Unique identifier for the treatment.
     * Auto-generated using IDENTITY strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Name of the treatment.
     * This field is required and cannot be null.
     */
    @Column(nullable = false, length = 200)
    private String name;

    /**
     * Detailed description of the treatment.
     * This field is required and cannot be null.
     */
    @Column(nullable = false, length = 500)
    private String description;

    /**
     * Cost of the treatment in dollars.
     * This field is required and cannot be null.
     */
    @Column(nullable = false)
    private Double cost;

    /**
     * Duration of the treatment in minutes.
     * This field is optional.
     */
    @Column
    private Integer duration;

    /**
     * ID of the associated diagnosis.
     * This field is required and links the treatment to a diagnosis.
     */
    @Column(name = "diagnosis_id", nullable = false)
    private Integer diagnosisId;

    /**
     * Treatment code (e.g., CPT code).
     * This field is optional.
     */
    @Column(length = 50)
    private String code;

    /**
     * Default no-argument constructor required by JPA.
     */
    public Treatment() {
    }

    /**
     * Constructor with essential fields.
     *
     * @param name Treatment name
     * @param description Treatment description
     * @param cost Treatment cost
     * @param diagnosisId Associated diagnosis ID
     */
    public Treatment(String name, String description, Double cost, Integer diagnosisId) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.diagnosisId = diagnosisId;
    }

    /**
     * Full constructor with all fields.
     *
     * @param name Treatment name
     * @param description Treatment description
     * @param cost Treatment cost
     * @param duration Treatment duration in minutes
     * @param diagnosisId Associated diagnosis ID
     * @param code Treatment code
     */
    public Treatment(String name, String description, Double cost, Integer duration,
                     Integer diagnosisId, String code) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.duration = duration;
        this.diagnosisId = diagnosisId;
        this.code = code;
    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(Integer diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Treatment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", duration=" + duration +
                ", diagnosisId=" + diagnosisId +
                ", code='" + code + '\'' +
                '}';
    }
}
