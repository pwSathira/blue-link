package com.polywertz.bluelink.ui;

import com.polywertz.bluelink.logic.CardController;
import com.polywertz.bluelink.logic.RoundedJTextField;
import com.polywertz.bluelink.logic.RoundedPanel;
import net.miginfocom.swing.MigLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class ChargesUI extends TemplateUI {

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
        RoundedPanel searchPanel = new RoundedPanel(20, Color.WHITE);
        searchPanel.setMinimumSize(new Dimension(300, 50));
        searchPanel.setMaximumSize(new Dimension(Short.MAX_VALUE, 50)); // Ensure the search panel does not exceed preferred height
        mainPanel.add(searchPanel, "dock north, span, height 50, gapbottom 20, wrap");

        // Add JLabels to the chargesContainer
        for (int i = 0; i < 20; i++) {
            JLabel label = new JLabel("Label " + (i + 1));
            label.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Add some padding around labels
            chargesContainer.add(label);
        }

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
    }
}
