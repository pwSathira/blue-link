package com.polywertz.bluelink.controller;

import com.polywertz.bluelink.db.Charges;
import com.polywertz.bluelink.db.IndictmentRepository;
import com.polywertz.bluelink.db.Profiles;
import com.polywertz.bluelink.logic.ConsoleColors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndictmentService {
    private final IndictmentRepository indictmentRepository;
    private Profiles currentProfile;

    @Autowired
    public IndictmentService(IndictmentRepository indictmentRepository) {
        // Default constructor
        this.indictmentRepository = indictmentRepository;
    }
    public void addIndictment(Charges charge) {
        // Additional business logic can be added here
        if (checkIndictmentExists(charge)){
            // Update the existing indictment
            addCountToIndictment(charge.getId());
        } else {
            // Create a new indictment
            createIndictment(charge);
        }

    }
    public void setCurrentProfile(Profiles currentProfile) {
        this.currentProfile = currentProfile;
    }
    private void createIndictment(Charges charge) {
        if(currentProfile != null) {
            // Create a new indictment
        } else {
            ConsoleColors.error("Blue-Link Error: No profile selected");
        }
    }

    private void addCountToIndictment(Long id) {

    }

    private boolean checkIndictmentExists(Charges charge) {

        return false;
    }

}
