package com.polywertz.bluelink.logic;

import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {
    private Image backgroundImage;
    public BackgroundPanel(String imagePath) {
        // Load the background image
        backgroundImage = new ImageIcon(imagePath).getImage();
        setLayout(new MigLayout("fill, insets 0"));
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Scale image to fit the panel
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
