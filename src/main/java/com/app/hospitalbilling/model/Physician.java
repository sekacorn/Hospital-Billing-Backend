package com.app.hospitalbilling.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

/**
 * Entity class representing a Physician in the hospital billing system.
 * This class maps to the 'physician' table in the database.
 *
 * A physician includes personal information, specialty, and contact details.
 */
@Entity
@Table(name = "physician")
public class Physician {

    /**
     * Unique identifier for the physician.
     * Auto-generated using IDENTITY strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * First name of the physician.
     * This field is required and cannot be null.
     */
    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    /**
     * Last name of the physician.
     * This field is required and cannot be null.
     */
    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    /**
     * Medical specialty of the physician (e.g., "Cardiology", "Neurology").
     * This field is required and cannot be null.
     */
    @Column(nullable = false, length = 100)
    private String specialty;

    /**
     * Contact phone number of the physician.
     * This field is optional.
     */
    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    /**
     * Email address of the physician.
     * This field is optional.
     */
    @Column(length = 100)
    private String email;

    /**
     * Medical license number of the physician.
     * This field is optional.
     */
    @Column(name = "license_number", length = 50)
    private String licenseNumber;

    /**
     * Default no-argument constructor required by JPA.
     */
    public Physician() {
    }

    /**
     * Constructor with essential fields.
     *
     * @param firstName First name
     * @param lastName Last name
     * @param specialty Medical specialty
     */
    public Physician(String firstName, String lastName, String specialty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
    }

    /**
     * Full constructor with all fields.
     *
     * @param firstName First name
     * @param lastName Last name
     * @param specialty Medical specialty
     * @param phoneNumber Contact phone
     * @param email Email address
     * @param licenseNumber License number
     */
    public Physician(String firstName, String lastName, String specialty,
                     String phoneNumber, String email, String licenseNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.licenseNumber = licenseNumber;
    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    @Override
    public String toString() {
        return "Physician{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", specialty='" + specialty + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                '}';
    }
}
