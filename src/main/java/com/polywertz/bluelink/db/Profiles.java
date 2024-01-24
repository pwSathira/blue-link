package com.polywertz.bluelink.db;

import jakarta.persistence.*;

@Entity
@Table(name = "bl_profiles")
public class Profiles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    public Profiles(String profile) {
        this.name = profile;
    }

    public Profiles() {
        // Default constructor
    }

    public Long getId() {
        return (id+1000);
    }

    public String getProfile() {
        return " "+ getId() +" | "+ this.name;
    }

}
