package com.polywertz.bluelink.ui;

import com.polywertz.bluelink.controller.UserService;
import com.polywertz.bluelink.logic.CardController;
import net.miginfocom.swing.MigLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

@Service
public class MainUI extends TemplateUI {

    @Autowired
    private static UserService userService;

    @Autowired
    public MainUI(CardController cardController) {
        super(cardController); // Call the constructor of TemplateUI
        JPanel mainPanel = this.rightPanel;
        mainPanel.setLayout(new MigLayout("wrap 3", "[grow]10[grow]10[grow]", "[]10[]10[]"));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JPanel badgePanel = addBadge();
        mainPanel.add(badgePanel, "cell 3 0, align right");

    }

    private JPanel addBadge() {
        JPanel badgePanel = new JPanel(new MigLayout("", "[grow]", "[][grow]"));
        ImageIcon icon = new ImageIcon("src/main/resources/static/mainui/badge.png");
        JLabel badgeIcon = new JLabel(icon);
        JLabel badgeNumber = new JLabel("#4050");
        badgeNumber.setFont(new Font("Haettenschweiler", Font.PLAIN, 30));
        badgeNumber.setForeground(new Color(0x379B8C));

        // MouseAdapter to handle hover effect
        MouseAdapter hoverEffect = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Darken the badgeNumber color
                badgeNumber.setForeground(badgeNumber.getForeground().darker());

                // Darken the badgeIcon
                Image img = ((ImageIcon) badgeIcon.getIcon()).getImage();
                Image newimg = createDarkerImage(img);
                badgeIcon.setIcon(new ImageIcon(newimg));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Revert the badgeNumber color
                badgeNumber.setForeground(new Color(0x379B8C));

                // Revert the badgeIcon
                badgeIcon.setIcon(icon);
            }
        };

        badgePanel.addMouseListener(hoverEffect);
        badgePanel.add(badgeNumber, "wrap, center");
        badgePanel.add(badgeIcon, "grow");
        return badgePanel;
    }

    private Image createDarkerImage(Image originalImage) {
        BufferedImage buffered = new BufferedImage(originalImage.getWidth(null), originalImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = buffered.createGraphics();
        g2d.drawImage(originalImage, 0, 0, null);
        g2d.dispose();
        // Apply a darkening filter or manually adjust the brightness
        RescaleOp rescaleOp = new RescaleOp(0.8f, 0, null);
        rescaleOp.filter(buffered, buffered);
        return buffered;
    }


}
