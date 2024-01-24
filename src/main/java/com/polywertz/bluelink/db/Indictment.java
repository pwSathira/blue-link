package com.polywertz.bluelink.db;

import jakarta.persistence.*;

@Entity
@Table(name = "bl_indictments")
public class Indictment {

    @Id
    private Long id;
    @Column(name = "ChargeId")
    private Long chargeId;
    @Column(name = "ChargeCount")
    private Integer chargeCount;

    public void setChargeCount(Integer chargeCount) {
        this.chargeCount = chargeCount;
    }

    public Integer getChargeCount() {
        return chargeCount;
    }

    public Indictment() {
        // Default constructor
    }

    public Indictment(Long currProfileId, Long currChargeId, Integer chargeCount) {
        this.id = currProfileId;
        this.chargeId = currChargeId;
        this.chargeCount = chargeCount;
    }
}
