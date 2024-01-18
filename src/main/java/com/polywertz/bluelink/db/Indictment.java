package com.polywertz.bluelink.db;

import jakarta.persistence.*;

@Entity
@Table(name = "bl_indictments")
public class Indictment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profiles profile;

    @ManyToOne
    @JoinColumn(name = "charge_id", referencedColumnName = "id")
    private Charges charge;

    @Column(name = "charge_count")
    private Integer chargeCount;

    public Indictment() {
        // Default constructor
    }
}
