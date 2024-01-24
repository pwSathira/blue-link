package com.polywertz.bluelink.ui;

import com.polywertz.bluelink.logic.*;
import net.miginfocom.swing.MigLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class GenericUI extends TemplateUI{
    protected final ItemContainer genericContainer;
    private final JPanel mainPanel;
    @Autowired
    public GenericUI(CardController ccInstance) {
        super(ccInstance);
        JPanel mainPanel = this.rightPanel;
        mainPanel.setLayout(new MigLayout("insets 0, fill")); // 'fill' will make components fill the space
        // Empty Border for Main Panel
        mainPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        // RoundedPanel for JScrollPane to have rounded corners
        RoundedPanel roundedScrollPanePanel = new RoundedPanel(20, new Color(0, 0, 0, 0)); // Transparent color
        roundedScrollPanePanel.setLayout(new BorderLayout()); // Use BorderLayout
        // ItemContainer for charges
        ItemContainer genericContainer = new ItemContainer(20, new Color(0x379B8C));
        // Create JScrollPane with rounded corners
        ItemPane itemPane = new ItemPane(genericContainer);
        // Add the JScrollPane to the roundedScrollPanePanel so that it inherits the rounded corners
        roundedScrollPanePanel.add(itemPane);
        // Add the roundedScrollPanePanel to the mainPanel
        mainPanel.add(roundedScrollPanePanel, "grow, wrap");
        this.genericContainer = genericContainer;
        this.mainPanel = mainPanel;
        ConsoleColors.info("ReportUI initialized");
    }
    public ItemContainer getGenericContainer() {
        return genericContainer;
    }
    public JPanel getMainPanel() {
        return mainPanel;
    }

}
