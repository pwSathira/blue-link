package com.polywertz.bluelink.UI;

import javax.swing.*;
import java.awt.*;

public class TemplateUI extends JPanel {
    public TemplateUI() {
        // Set a layout for the panel
        setLayout(new BorderLayout());

        // Create and add some components
        JLabel label = new JLabel("This is a template JPanel.");
        JButton button = new JButton("Click Me!");

        // Add the components to the panel
        add(label, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);
    }
}
