package com.app.hospitalbilling.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

/**
 * Entity class representing a Diagnosis in the hospital billing system.
 * This class maps to the 'diagnosis' table in the database.
 *
 * A diagnosis includes a medical code (such as ICD-10), description,
 * category, and active status.
 */
@Entity
@Table(name = "diagnosis")
public class Diagnosis {

    /**
     * Unique identifier for the diagnosis.
     * Auto-generated using IDENTITY strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Diagnosis code (e.g., ICD-10 code like "A00.0").
     * This field is required and cannot be null.
     */
    @Column(nullable = false, length = 50)
    private String code;

    /**
     * Detailed description of the diagnosis.
     * This field is required and cannot be null.
     */
    @Column(nullable = false, length = 500)
    private String description;

    /**
     * Category of the diagnosis (e.g., "Infectious Disease", "Cardiovascular").
     * This field is optional.
     */
    @Column(length = 100)
    private String category;

    /**
     * Indicates whether the diagnosis is currently active.
     * Defaults to true.
     */
    @Column(name = "is_active")
    private Boolean isActive = true;

    /**
     * Default no-argument constructor required by JPA.
     */
    public Diagnosis() {
    }

    /**
     * Constructor with essential fields.
     *
     * @param code Diagnosis code
     * @param description Diagnosis description
     */
    public Diagnosis(String code, String description) {
        this.code = code;
        this.description = description;
        this.isActive = true;
    }

    /**
     * Full constructor with all fields.
     *
     * @param code Diagnosis code
     * @param description Diagnosis description
     * @param category Diagnosis category
     * @param isActive Active status
     */
    public Diagnosis(String code, String description, String category, Boolean isActive) {
        this.code = code;
        this.description = description;
        this.category = category;
        this.isActive = isActive;
    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "Diagnosis{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
