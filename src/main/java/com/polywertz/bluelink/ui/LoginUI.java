package com.polywertz.bluelink.ui;
import com.polywertz.bluelink.controller.UserService;
import com.polywertz.bluelink.db.User;
import com.polywertz.bluelink.logic.BackgroundPanel;
import com.polywertz.bluelink.logic.CardController;
import net.miginfocom.swing.MigLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Component
public class LoginUI extends JPanel {
    private final JTextField usernameField;
    private final JPasswordField passwordField;

    @Autowired
    private UserService userService;

    private CardController ccInstance;

    @Autowired
    public LoginUI(CardController ccInstance) {
        this.ccInstance = ccInstance;
        ImageIcon titleIcon = new ImageIcon("src/main/resources/static/loginui/BLink_LoginUI_Logo.png");
        titleIcon = resizeIcon(titleIcon, 300, 70);
        ImageIcon buttonIcon = new ImageIcon("src/main/resources/static/loginui/BLink_LoginUI_Arrow_Light.png");
        buttonIcon = resizeIcon(buttonIcon, 50, 50);

        // Use MigLayout as the main layout manager with two columns
        setLayout(new MigLayout("insets 0, fill", "[30%]0[70%]", "[grow]"));

        // Initialize the left panel with MigLayout for the login form
        JPanel leftPanel = new JPanel(new MigLayout("wrap 2", "[][grow,fill]", "[]10[]10[]10[]"));
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setBorder(new EmptyBorder(20,20,20,20));
        JLabel titleLabel = new JLabel(titleIcon);
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
//        JCheckBox rememberMeCheckbox = new JCheckBox("Remember Me");
        JButton loginButton = new JButton(buttonIcon);
        buttonIconFunctions(loginButton);
        passwordFieldFunctions(passwordField);
        JLabel footerLabel = new JLabel("version 0.1 Alpha");
        footerLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("Arial", Font.BOLD, 12));
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 12));

        // Add components to the left panel
        leftPanel.add(titleLabel, "span, align center, wrap, gaptop 100");
        leftPanel.add(usernameLabel);
        leftPanel.add(usernameField, "align center, wrap");
        leftPanel.add(passwordLabel);
        leftPanel.add(passwordField, "align center, wrap");
//        leftPanel.add(rememberMeCheckbox, "span, wrap");
        leftPanel.add(loginButton, "span, align center");
        leftPanel.add(footerLabel, "span, align center, wrap");

        // Initialize the right panel to display a background image that fills the space
        BackgroundPanel rightPanel = new BackgroundPanel("src/main/resources/static/loginui/BLink_LoginUI_BG.png");
        rightPanel.setBackground(new Color(0x379B8C));

        // Add both panels to the main panel
        add(leftPanel, "grow");
        add(rightPanel, "grow");
    }

    private void passwordFieldFunctions(JPasswordField passwordField) {
        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER){
                    determineLoginStatus();
                }
            }
        });
    }

    private void determineLoginStatus() {
        if (userService.checkUser(usernameField.getText(), new String(passwordField.getPassword()))) {
            User user = userService.findUser(usernameField.getText());
            userService.setCurrentUser(user);
            ccInstance.addLoginCards();

        } else {
            JOptionPane.showMessageDialog(null, "Username/Password invalid");
        }
    }

    private void buttonIconFunctions(JButton loginButton) {
        loginButton.setBorder(null);
        loginButton.setFocusPainted(false);
        loginButton.setContentAreaFilled(false);
        loginButton.setFocusable(false);
        //Button Hover Effects
        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                loginButton.setIcon(resizeIcon(new ImageIcon("src/main/resources/static/loginui/BLink_LoginUI_Arrow_Dark.png"), 50, 50));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                loginButton.setIcon(resizeIcon(new ImageIcon("src/main/resources/static/loginui/BLink_LoginUI_Arrow_Light.png"), 50, 50));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                determineLoginStatus();
            }
        });

    }
    private ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

}

