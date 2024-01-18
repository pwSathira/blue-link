package com.polywertz.bluelink.logic;

import java.awt.*;
import javax.swing.*;

public class ItemPanel extends RoundedPanel{
    public ItemPanel(int radius, Color color, String text) {
        super(radius, color);
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
