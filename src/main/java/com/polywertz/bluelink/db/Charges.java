package com.polywertz.bluelink.db;

import jakarta.persistence.*;

@Entity // This annotation marks the class as a database entity
@Table(name = "bl_charges") // This annotation defines the table name
public class Charges {

    @Id // This annotation marks the field as a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This defines the primary key generation strategy
    private Long id;

    private String category; // For example, "Motor Vehicular Charges"
    private String name; // For example, "Running a Red Light"
    private String description; // A brief description of the charge
    private String felonyType; // For example, "Class A"
    private Integer timeInMonths; // The time associated with the charge, in months
    private Integer fine; // The fine amount in dollars

    public Charges() {
        // Default constructor
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getFelonyType() {
        return felonyType;
    }

    public void setFelonyType(String felonyType) {
        this.felonyType = felonyType;
    }

    public Integer getTimeInMonths() {
        return timeInMonths;
    }

    public void setTimeInMonths(Integer timeInMonths) {
        this.timeInMonths = timeInMonths;
    }

    public Integer getFine() {
        return fine;
    }

    public void setFine(Integer fine) {
        this.fine = fine;
    }

    public String getCharge() {
        return " "+ this.name + " | " + this.description + " | " + this.timeInMonths + " Months | $" + this.fine;
    }
}
