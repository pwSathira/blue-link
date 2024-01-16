package com.polywertz.bluelink.logic;

import javax.swing.*;
import java.awt.*;

import static java.awt.Component.*;

public class ItemPanel extends RoundedPanel{
    public ItemPanel(String text) {
        super(20, Color.BLACK);
        setLayout(new FlowLayout(FlowLayout.LEFT, 0, 5));
        setPreferredSize(new Dimension(500, 50));
        setMinimumSize(new Dimension(500, 50));
        setMaximumSize(new Dimension(Short.MAX_VALUE, 50));

        JLabel chargeLabel = new JLabel(text);
        chargeLabel.setFont(new Font("Haettenschweiler", Font.PLAIN, 30));
        chargeLabel.setForeground(Color.WHITE);

        add(chargeLabel);
        setAlignmentX(LEFT_ALIGNMENT);
    }

}
