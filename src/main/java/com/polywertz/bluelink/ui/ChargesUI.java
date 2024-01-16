package com.polywertz.bluelink.ui;

import com.polywertz.bluelink.controller.ChargesService;
import com.polywertz.bluelink.db.Charges;
import com.polywertz.bluelink.logic.CardController;
import com.polywertz.bluelink.logic.ItemContainer;
import com.polywertz.bluelink.logic.ItemPanel;
import com.polywertz.bluelink.logic.RoundedPanel;
import jakarta.annotation.PostConstruct;
import net.miginfocom.swing.MigLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class ChargesUI extends TemplateUI {

    private ItemContainer itemContainer;
    @Autowired
    private ChargesService chargesService;
    private JPanel mainPanel;

    @Autowired
    public ChargesUI(CardController ccInstance) {
        super(ccInstance);
        mainPanel = this.rightPanel;
        mainPanel.setLayout(new MigLayout("insets 0, fill")); // 'fill' will make components fill the space
        mainPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
    }

    @PostConstruct
    private void init() {
        itemContainer = new ItemContainer(this::updateChargesDisplay);
        JScrollPane scrollPane = new JScrollPane(itemContainer);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        mainPanel.add(scrollPane, "grow, wrap");
        mainPanel.add(itemContainer, "grow, wrap");
        updateChargesDisplay("");
    }

    private void addChargesToContainer(Iterable<com.polywertz.bluelink.db.Charges> charges) {
        itemContainer.removeAll(); // Clear existing charges
        for (com.polywertz.bluelink.db.Charges charge : charges) {
            ItemPanel itemPanel = new ItemPanel(charge.getCharge());
            itemContainer.add(Box.createRigidArea(new Dimension(0, 10))); // 10-pixel gap
            itemContainer.add(itemPanel);
        }
        itemContainer.revalidate();
        itemContainer.repaint();
    }

    private void updateChargesDisplay(String searchTerm) {
        Iterable<Charges> filteredCharges = chargesService.findChargesBySearchTerm(searchTerm);
        addChargesToContainer(filteredCharges);
    }
}
