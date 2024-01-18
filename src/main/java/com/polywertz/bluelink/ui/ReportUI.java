package com.polywertz.bluelink.ui;

import com.polywertz.bluelink.controller.UserService;
import com.polywertz.bluelink.logic.CardController;
import com.polywertz.bluelink.logic.ItemContainer;
import com.polywertz.bluelink.logic.ItemPane;
import com.polywertz.bluelink.logic.RoundedPanel;
import net.miginfocom.swing.MigLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class ReportUI extends TemplateUI {

    @Autowired
    private UserService userService;

    private final ItemContainer reportsContainer;
    @Autowired
    public ReportUI(CardController ccInstance) {
        super(ccInstance); // Call the constructor of TemplateUI
        JPanel mainPanel = this.rightPanel;
        mainPanel.setLayout(new MigLayout("insets 0, fill")); // 'fill' will make components fill the space
        // Empty Border for Main Panel
        mainPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        // RoundedPanel for JScrollPane to have rounded corners
        RoundedPanel roundedScrollPanePanel = new RoundedPanel(20, new Color(0, 0, 0, 0)); // Transparent color
        roundedScrollPanePanel.setLayout(new BorderLayout()); // Use BorderLayout
        // ItemContainer for charges
        ItemContainer reportsContainer = new ItemContainer(20, new Color(0x379B8C));
        // Add the search bar above the bluePanel
        SearchBarUI searchBar = new SearchBarUI(this::updateReportsDisplay);
        mainPanel.add(searchBar, "dock north, width 500, height 50, span, gapbottom 20, wrap");
        // Create JScrollPane with rounded corners
        ItemPane itemPane = new ItemPane(reportsContainer);
        // Add the JScrollPane to the roundedScrollPanePanel so that it inherits the rounded corners
        roundedScrollPanePanel.add(itemPane);
        // Add the roundedScrollPanePanel to the mainPanel
        mainPanel.add(roundedScrollPanePanel, "grow, wrap");
        this.reportsContainer = reportsContainer;
    }

    private void updateReportsDisplay(String s) {
    }
}
