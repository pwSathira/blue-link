package com.polywertz.bluelink.ui;

import com.polywertz.bluelink.controller.UserService;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class MainUI extends TemplateUI {
    public MainUI(UserService userService) {
        super(userService); // Call the constructor of TemplateUI
        JPanel mainPanel = this.rightPanel;
        mainPanel.setLayout(new MigLayout("debug, insets 0, gap 0", "[grow]10[grow]10[grow]", "[]10[]10[]"));

        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        ImageIcon icon = new ImageIcon("src/main/resources/static/mainui/badge.png");
        JLabel label = new JLabel(icon);
        mainPanel.add(label, "cell 2 0, align right");

    }

}
