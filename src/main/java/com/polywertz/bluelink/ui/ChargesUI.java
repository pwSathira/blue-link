package com.polywertz.bluelink.ui;

import com.polywertz.bluelink.controller.ChargesService;
import com.polywertz.bluelink.db.Charges;
import com.polywertz.bluelink.logic.CardController;
import com.polywertz.bluelink.logic.RoundedPanel;
import jakarta.annotation.PostConstruct;
import net.miginfocom.swing.MigLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class ChargesUI extends TemplateUI {

    private final RoundedPanel chargesContainer;

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

        // Blue Rectangle Panel for MainPanel
        RoundedPanel chargesContainer = new RoundedPanel(20, new Color(0x379B8C));
        chargesContainer.setLayout(new BoxLayout(chargesContainer, BoxLayout.Y_AXIS)); // Use BoxLayout for vertical stacking
        // Add the search bar above the bluePanel
        SearchBarUI searchBar = new SearchBarUI(this::updateChargesDisplay);
        mainPanel.add(searchBar, "dock north, width 500, height 50, span, gapbottom 20, wrap");

        // Create JScrollPane with rounded corners
        JScrollPane scrollPane = new JScrollPane(chargesContainer);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setFocusable(false);

        // Add the JScrollPane to the roundedScrollPanePanel so that it inherits the rounded corners
        roundedScrollPanePanel.add(scrollPane);

        // Add the roundedScrollPanePanel to the mainPanel
        mainPanel.add(roundedScrollPanePanel, "grow, wrap");
        chargesContainer.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        this.chargesContainer = chargesContainer;
    }

    @PostConstruct
    private void init() {
        // Initialize with all charges
        addChargesToContainer(chargesService.getAllCharges());
    }

    private void addChargesToContainer(Iterable<com.polywertz.bluelink.db.Charges> charges) {
        chargesContainer.removeAll(); // Clear existing charges
        for (com.polywertz.bluelink.db.Charges charge : charges) {
            RoundedPanel chargePanel = createChargePanel(charge.getCharge());
            chargesContainer.add(Box.createRigidArea(new Dimension(0, 10))); // 10-pixel gap
            chargesContainer.add(chargePanel);
        }
        chargesContainer.revalidate();
        chargesContainer.repaint();
    }

    private RoundedPanel createChargePanel(String chargeText) {
        RoundedPanel chargePanel = new RoundedPanel(20, Color.BLACK);
        chargePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));
        chargePanel.setPreferredSize(new Dimension(500, 50));
        chargePanel.setMinimumSize(new Dimension(500, 50));
        chargePanel.setMaximumSize(new Dimension(Short.MAX_VALUE, 50));

        JLabel chargeLabel = new JLabel(chargeText);
        chargeLabel.setFont(new Font("Haettenschweiler", Font.PLAIN, 30));
        chargeLabel.setForeground(Color.WHITE);

        chargePanel.add(chargeLabel);
        chargePanel.setAlignmentX(LEFT_ALIGNMENT);
        return chargePanel;
    }

    private void updateChargesDisplay(String searchTerm) {
        Iterable<Charges> filteredCharges = chargesService.findChargesBySearchTerm(searchTerm);
        addChargesToContainer(filteredCharges);
    }
}
