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
public class ChargesUI extends TemplateUI {
    private final ItemContainer chargesContainer;
    @Autowired
    private ChargesService chargesService;
    @Autowired
    public ChargesUI(CardController ccInstance) {
        super(ccInstance);
        JPanel mainPanel = this.rightPanel;
        mainPanel.setLayout(new MigLayout("insets 0, fill")); // 'fill' will make components fill the space
        // Empty Border for Main Panel
        mainPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        // RoundedPanel for JScrollPane to have rounded corners
        RoundedPanel roundedScrollPanePanel = new RoundedPanel(20, new Color(0, 0, 0, 0)); // Transparent color
        roundedScrollPanePanel.setLayout(new BorderLayout()); // Use BorderLayout
        // ItemContainer for charges
        ItemContainer chargesContainer = new ItemContainer(20, new Color(0x379B8C));
        // Add the search bar above the bluePanel
        SearchBarUI searchBar = new SearchBarUI(this::updateChargesDisplay);
        mainPanel.add(searchBar, "dock north, width 500, height 50, span, gapbottom 20, wrap");
        // Create JScrollPane with rounded corners
        ItemPane itemPane = new ItemPane(chargesContainer);
        // Add the JScrollPane to the roundedScrollPanePanel so that it inherits the rounded corners
        roundedScrollPanePanel.add(itemPane);
        // Add the roundedScrollPanePanel to the mainPanel
        mainPanel.add(roundedScrollPanePanel, "grow, wrap");
        this.chargesContainer = chargesContainer;
    }
    @PostConstruct
    private void init() {
        // Initialize with all charges
        addChargesToContainer(chargesService.getAllCharges());
    }

    private void addChargesToContainer(Iterable<com.polywertz.bluelink.db.Charges> charges) {
        chargesContainer.clearItems(); // Clear existing charges
        for (com.polywertz.bluelink.db.Charges charge : charges) {
            ItemPanel chargePanel = new ItemPanel(20, Color.BLACK, charge.getCharge());
            chargesContainer.addItem(chargePanel);
        }
    }
    private void updateChargesDisplay(String searchTerm) {
        Iterable<Charges> filteredCharges = chargesService.findChargesBySearchTerm(searchTerm);
        addChargesToContainer(filteredCharges);
    }
}
