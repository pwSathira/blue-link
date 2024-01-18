package com.polywertz.bluelink.logic;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class IconRecolor {
public static ImageIcon changeIconColor(ImageIcon icon, Color color) {
    BufferedImage img = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
    Graphics g = img.createGraphics();
    icon.paintIcon(null, g, 0, 0);
    g.dispose();

    for (int i = 0; i < img.getWidth(); i++) {
        for (int j = 0; j < img.getHeight(); j++) {
            int px = img.getRGB(i, j);
            if ((px>>24) != 0x00) { // Check if pixel is not fully transparent
                img.setRGB(i, j, color.getRGB());
            }
        }
    }
    return new ImageIcon(img);
    }
}
