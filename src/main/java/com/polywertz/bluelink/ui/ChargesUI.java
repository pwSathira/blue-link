package com.polywertz.bluelink.ui;

import com.polywertz.bluelink.controller.ChargesService;
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
        SearchBarUI searchBar = new SearchBarUI();
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
        
        this.chargesContainer = chargesContainer;
    }

    @PostConstruct
    private void init(){
        // Add JLabels to the chargesContainer
        addCharges(chargesContainer);
    }

    private void addCharges(RoundedPanel chargesContainer) {
        //Get number of charges from database
        int chargesNumber = chargesService.getNumberCharges();
        System.out.println("Number of charges: " + chargesNumber);

        for (int i = 0; i < 10; i++) {
            RoundedPanel chargePanel = new RoundedPanel(20, new Color(0x379B8C));
            chargePanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
            chargePanel.setPreferredSize(new Dimension(500, 50));
            chargePanel.setMaximumSize(new Dimension(500, 50));
            chargePanel.setMinimumSize(new Dimension(500, 50));

            JLabel chargeLabel = new JLabel("Charge " + i);
            chargeLabel.setFont(new Font("Haettenschweiler", Font.PLAIN, 30));
            chargeLabel.setForeground(Color.WHITE);

            chargePanel.add(chargeLabel);
            chargesContainer.add(chargePanel);
        }
    }
}
