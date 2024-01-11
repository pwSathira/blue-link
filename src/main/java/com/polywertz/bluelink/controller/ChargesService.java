package com.polywertz.bluelink.controller;

import com.polywertz.bluelink.db.Charges;
import com.polywertz.bluelink.db.ChargesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChargesService {
    private final ChargesRepository chargesRepository;
    @Autowired
    public ChargesService(ChargesRepository chargesRepository) {
        this.chargesRepository = chargesRepository;
    }
    // Method to add a new charge
    public Charges addCharge(Charges charge) {
        // Additional business logic can be added here
        return chargesRepository.save(charge);
    }
    // Method to find charges by category
    public Iterable<Charges> findChargesByCategory(String category) {
        return chargesRepository.findByCategory(category);
    }
    // Method to find charges by felony type
    public Iterable<Charges> findChargesByFelonyType(String felonyType) {
        return chargesRepository.findByFelonyType(felonyType);
    }

    public int getNumberCharges() {
        int count = 0;
        while (chargesRepository.findAll().iterator().hasNext()) {
            count++;
        }
        return count;
    }
}
