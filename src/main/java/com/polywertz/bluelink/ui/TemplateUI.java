package com.polywertz.bluelink.ui;

import com.polywertz.bluelink.controller.UserService;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static com.polywertz.bluelink.ui.ApplicationUI.ccInstance;

public class TemplateUI extends JPanel {

    // Variable Declarations
    protected JButton bluelinkButton;
    protected JButton profilesButton;
    protected JButton chargesButton;
    protected JButton reportButton;
    protected JButton settingsButton;
    protected JPanel rightPanel;
    protected JPanel leftPanel;
    private UserService userService;

    // Constructor
    public TemplateUI(UserService userService) {
        this.userService = userService;
        setupLayout();
        initializeComponents();
        addComponents(leftPanel);
    }

    // Layout and Component Initialization
    private void setupLayout() {
        setLayout(new MigLayout("insets 0, fill", "[5%]0[95%]", "[grow]"));
        setBackground(new Color(0, 43, 54));

        // Creating the left and right panels
        JPanel leftPanel = createLeftPanel();
        JPanel rightPanel = new JPanel(new MigLayout("fill, insets 0"));

        add(leftPanel, "grow");
        add(rightPanel, "grow");

        this.rightPanel = rightPanel;
        this.leftPanel = leftPanel;
    }

    private JPanel createLeftPanel() {
        JPanel leftPanel = new JPanel(new MigLayout("wrap 1", "[][grow,fill]", "[]20[]20[]20[]20[]20[]"));
        leftPanel.setBackground(new Color(0x379B8C));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        return leftPanel;
    }

    // Component Creation and Styling
    protected void initializeComponents() {
        // Initialization of buttons and their styles
        String root = "src/main/resources/static/templateui/";
        Font buttonFont = new Font("Arial", Font.BOLD, 18);
        Color textColor = new Color(238, 232, 213);

        bluelinkButton = createButton(root + "bluelink_alt.png", root + "bluelink_dark.png", "main");
        profilesButton = createButton(root + "profile.png", root + "profile_alt.png", "profiles");
        chargesButton = createButton(root + "charges.png", root + "charges_alt.png", "charges");
        reportButton = createButton(root + "report.png", root + "report_alt.png", "report");
        settingsButton = createButton(root + "settings.png", root + "setting_alt.png", "settings");

        setButtonStyle(bluelinkButton, buttonFont, textColor);
        setButtonStyle(profilesButton, buttonFont, textColor);
        setButtonStyle(chargesButton, buttonFont, textColor);
        setButtonStyle(reportButton, buttonFont, textColor);
        setButtonStyle(settingsButton, buttonFont, textColor);
    }

    protected void addComponents(JPanel leftPanel) {
        // Adding buttons to the left panel
        leftPanel.add(bluelinkButton, "height 50:55:60, center, wrap");
        leftPanel.add(profilesButton, "height 50:55:60, center, wrap");
        leftPanel.add(chargesButton, "height 50:55:60, center, wrap");
        leftPanel.add(reportButton, "height 50:55:60, center, wrap");
        leftPanel.add(new JLabel(""), "push, grow"); // Invisible label to push buttons down
        leftPanel.add(settingsButton, "height 50:55:60, center, wrap");
    }

    // Helper Methods for UI Elements
    protected JButton createButton(String defaultImagePath, String hoverImagePath, String cardName) {
        // Button creation with icon and mouse events for interaction
        JButton button = new JButton(createButtonIcon(defaultImagePath));
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setIcon(createButtonIcon(hoverImagePath));
            }
            public void mouseExited(MouseEvent e) {
                button.setIcon(createButtonIcon(defaultImagePath));
            }
            public void mouseClicked(MouseEvent e) {
                ccInstance.showCard(cardName);
            }
        });
        return button;
    }

    protected ImageIcon createButtonIcon(String imagePath) {
        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(180, 50, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    protected void setButtonStyle(JButton button, Font font, Color textColor) {
        button.setFont(font);
        button.setForeground(textColor);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
    }
}
