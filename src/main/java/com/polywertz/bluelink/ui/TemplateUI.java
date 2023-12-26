package com.polywertz.bluelink.ui;

import com.polywertz.bluelink.controller.UserService;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static com.polywertz.bluelink.ui.ApplicationUI.ccInstance;


public class TemplateUI extends JPanel {
    protected JButton bluelinkButton;
    protected JButton profilesButton;
    protected JButton chargesButton;
    protected JButton reportButton;
    protected JButton settingsButton;
    private UserService userService;

    public TemplateUI(UserService userService) {
        this.userService = userService;
        System.out.println();

        // Setting the layout for the main panel to fill the entire space
        setLayout(new MigLayout("insets 0, fill", "[5%]0[95%]", "[grow]"));
        setBackground(Color.white); // Setting a white background color for the main panel
        // Creating the left panel with its own layout
        JPanel leftPanel = new JPanel(new MigLayout("wrap 1", "[][grow,fill]", "[]20[]20[]20[]20[]20[]"));
        leftPanel.setBorder((BorderFactory.createEmptyBorder(20, 20, 20, 20))); // Adding padding to the main panel
        JPanel rightPanel = new JPanel(new MigLayout("fill, insets 0"));
        leftPanel.setBackground(new Color(0x379B8C)); // Setting a dark background color similar to the UI in the image

        initializeComponents();
        addComponents(leftPanel);

        // Adding the left panel to the main panel
        add(leftPanel, "grow");
        add(rightPanel, "grow");

        setBackground(new Color(0, 43, 54)); // Setting a dark background color similar to the UI in the image
    }

    protected void initializeComponents() {
        // Initialize buttons with appropriate text and icons
        String root = "src/main/resources/static/templateui/";
        bluelinkButton = createButton(root + "bluelink_alt.png",
                root + "bluelink_dark.png",
                "main");
        profilesButton = createButton(root + "profile.png",
                root + "profile_alt.png",
                "profiles");
        chargesButton = createButton(root + "charges.png",
                root + "charges_alt.png",
                "charges");
        reportButton = createButton(root + "report.png",
                root + "report_alt.png",
                root + "report");
        settingsButton = createButton(root + "settings.png",
                root + "setting_alt.png",
                "settings");

        // Set button font and color to match the UI theme from the image
        Font buttonFont = new Font("Arial", Font.BOLD, 18);
        Color textColor = new Color(238, 232, 213); // Light color for text for contrast

        setButtonStyle(bluelinkButton, buttonFont, textColor);
        setButtonStyle(profilesButton, buttonFont, textColor);
        setButtonStyle(chargesButton, buttonFont, textColor);
        setButtonStyle(reportButton, buttonFont, textColor);
        setButtonStyle(settingsButton, buttonFont, textColor);
    }

    protected ImageIcon createButton(String imagePath) {
        // Load the original image
        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image originalImage = originalIcon.getImage();
        // Resize the image (Change the width and height to your desired size)
        Image resizedImage = originalImage.getScaledInstance(180, 50, Image.SCALE_SMOOTH);
        // Convert the Image back to an ImageIcon for the button
        return new ImageIcon(resizedImage);
    }

    protected JButton createButton(String defaultImagePath, String hoverImagePath, String cardName) {
        JButton button = new JButton(createButton(defaultImagePath));
        // Add mouse listener for hover effect
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setIcon(createButton(hoverImagePath));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button.setIcon(createButton(defaultImagePath));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                button.setIcon(createButton(hoverImagePath));
                ccInstance.showCard(cardName);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                button.setIcon(createButton(hoverImagePath));
            }
        });

        return button;
    }

    protected void setButtonStyle(JButton button, Font font, Color textColor) {
        button.setFont(font);
        button.setForeground(textColor);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        // Additional styling can be added here, such as hover effects, padding, etc.
    }

    protected void addComponents(JPanel leftPanel) {
        // Add components to the left panel with constraints
        leftPanel.add(bluelinkButton, "height 50:55:60, center, wrap");
        leftPanel.add(profilesButton, "height 50:55:60, center, wrap");
        leftPanel.add(chargesButton, "height 50:55:60, center, wrap");
        leftPanel.add(reportButton, "height 50:55:60, center, wrap");
        leftPanel.add(new JLabel(""), "push, grow"); // Invisible label to push the next components to the bottom
        leftPanel.add(settingsButton, "height 50:55:60, center, wrap"); // Last element near the bottom
    }
}
