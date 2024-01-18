package com.polywertz.bluelink.db;

import jakarta.persistence.*;

@Entity
@Table(name = "bl_profiles")
public class Profiles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    public Profiles() {
        // Default constructor
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
}
