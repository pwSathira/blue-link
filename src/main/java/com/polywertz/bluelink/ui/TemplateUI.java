package com.polywertz.bluelink.ui;

import javax.swing.*;
import java.awt.*;

public class TemplateUI extends JPanel {
    protected JLabel label;
    protected JButton button;

    public TemplateUI() {
        setLayout(new BorderLayout());
        initializeComponents();
        addComponents();
    }

    protected void initializeComponents() {
        // Initialize components with default values
        label = new JLabel("This is a template JPanel.");
        button = new JButton("Click Me!");
    }

    protected void addComponents() {
        // Add components to the layout
        add(label, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);
    }
}
