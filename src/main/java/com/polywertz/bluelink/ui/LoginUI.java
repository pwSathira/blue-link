package com.polywertz.bluelink.ui;
import com.polywertz.bluelink.controller.UserService;
import com.polywertz.bluelink.db.User;
import com.polywertz.bluelink.logic.BackgroundPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginUI extends JPanel {
    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private UserService userService;

    public LoginUI(UserService userService) {
        this.userService = userService;
        ImageIcon titleIcon = new ImageIcon("src/main/resources/static/loginui/BLink_LoginUI_Logo.png");
        titleIcon = resizeIcon(titleIcon, 300, 70);
        ImageIcon buttonIcon = new ImageIcon("src/main/resources/static/loginui/BLink_LoginUI_Arrow_Light.png");
        buttonIcon = resizeIcon(buttonIcon, 50, 50);

        // Use MigLayout as the main layout manager with two columns
        setLayout(new MigLayout("debug, insets 0, fill", "[30%]0[70%]", "[grow]"));

        // Initialize the left panel with MigLayout for the login form
        JPanel leftPanel = new JPanel(new MigLayout("wrap 2", "[][grow,fill]", "[]10[]10[]10[]"));
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setBorder(new EmptyBorder(20,20,20,20));
        JLabel titleLabel = new JLabel(titleIcon);
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        JCheckBox rememberMeCheckbox = new JCheckBox("Remember Me");
        JButton loginButton = new JButton(buttonIcon);
        buttonIconFunctions(loginButton);
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
        leftPanel.add(rememberMeCheckbox, "span, wrap");
        leftPanel.add(loginButton, "span, align center");
        leftPanel.add(footerLabel, "span, align center, wrap");

        // Initialize the right panel to display a background image that fills the space
        BackgroundPanel rightPanel = new BackgroundPanel("src/main/resources/static/loginui/BLink_LoginUI_BG.png");
        rightPanel.setBackground(new Color(0x379B8C));

        // Add both panels to the main panel
        add(leftPanel, "grow");
        add(rightPanel, "grow");
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
                createUser();
            }
        });
    }
    private ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    private void createUser() {
        String username = usernameField.getText();
        char[] password = passwordField.getPassword();

        // Here, you would typically hash the password before storing it
        // For the sake of this example, we'll just convert it to a String
        String passwordString = new String(password);

        // Assuming UserService has a method to create users
        User newUser = userService.createUser(username, passwordString);
        if (newUser != null) {
            JOptionPane.showMessageDialog(this, "User created successfully!");
        } else {
            JOptionPane.showMessageDialog(this, "Failed to create user.");
        }
    }
}

