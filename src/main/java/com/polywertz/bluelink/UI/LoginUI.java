package com.polywertz.bluelink.UI;

import javax.swing.*;
import java.awt.*;

public class LoginUI extends JPanel {
    // Declare components
    private JButton loginButton;
    private JButton registerButton;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;

    public LoginUI() {
        // Layout of the LoginUI
        setLayout(new BorderLayout());

        JPanel loginComp = LoginComp();

        // Add the loginComp to the west (left) of the LoginUI panel
        add(loginComp, BorderLayout.WEST);
    }

    private JPanel LoginComp() {
        JPanel login = new JPanel();

        // Initialize components
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");

        // Create layout
        login.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // Align components to the left side
        constraints.anchor = GridBagConstraints.WEST;

        // Add Username Label
        constraints.gridx = 0;
        constraints.gridy = 0;
        login.add(usernameLabel, constraints);

        // Add Username Field
        constraints.gridx = 1;
        login.add(usernameField, constraints);

        // Add Password Label
        constraints.gridy = 1;
        constraints.gridx = 0;
        login.add(passwordLabel, constraints);

        // Add Password Field
        constraints.gridx = 1;
        login.add(passwordField, constraints);

        // Add Login Button
        constraints.gridy = 2;
        constraints.gridx = 0;
        login.add(loginButton, constraints);

        // Add Register Button
        constraints.gridx = 1;
        login.add(registerButton, constraints);
        return login;
    }
}
