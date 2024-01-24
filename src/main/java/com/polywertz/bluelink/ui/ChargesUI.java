package com.polywertz.bluelink.ui;

import com.polywertz.bluelink.controller.ChargesService;
import com.polywertz.bluelink.db.Charges;
import com.polywertz.bluelink.db.Profiles;
import com.polywertz.bluelink.logic.*;
import jakarta.annotation.PostConstruct;
import net.miginfocom.swing.MigLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

@Component
public class ChargesUI extends GenericUI {
    private final ItemContainer chargesContainer;
    @Autowired
    private ChargesService chargesService;
    @Autowired
    public ChargesUI(CardController ccInstance) {
        super(ccInstance);
        JPanel mainPanel = getMainPanel();
        // Add the search bar above the bluePanel
        SearchBarUI searchBar = new SearchBarUI(this::updateChargesDisplay);
        mainPanel.add(searchBar, "dock north, width 500, height 50, span, gapbottom 20, wrap");
        this.chargesContainer = getGenericContainer();
    }
    @PostConstruct
    private void init() {
        // Initialize with all charges
        addChargesToContainer(chargesService.getAllCharges());
    }

    private void addChargesToContainer(Iterable<Charges> charges) {
        chargesContainer.clearItems(); // Clear existing charges
        for (Charges charge : charges) {
            ItemPanel chargePanel = new ItemPanel(20, Color.BLACK, charge.getCharge());
            chargesContainer.addItem(chargePanel);
        }
    }
    private void updateChargesDisplay(String searchTerm) {
        Iterable<Charges> filteredCharges = chargesService.findChargesBySearchTerm(searchTerm);
        addChargesToContainer(filteredCharges);
    }
}
