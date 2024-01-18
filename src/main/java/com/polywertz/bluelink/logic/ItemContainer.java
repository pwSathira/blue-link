package com.polywertz.bluelink.logic;

import javax.swing.*;
import java.awt.*;

public class ItemContainer extends RoundedPanel {
    public ItemContainer(int radius, Color color) {
        super(radius, color);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Default layout
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Default border
    }
    public void addItem(JComponent component) {
        if (getComponentCount() > 0) { // Add padding before adding if not the first component
            add(Box.createRigidArea(new Dimension(0, 10))); // 10-pixel gap
        }
        add(component);
    }
    public void clearItems() {
        removeAll();
        revalidate();
        repaint();
    }
}
