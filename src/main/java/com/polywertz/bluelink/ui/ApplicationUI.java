package com.polywertz.bluelink.ui;

import javax.swing.*;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.polywertz.bluelink.controller.UserService;

public class ApplicationUI extends JFrame {
    public static CardController ccInstance;
    private final UserService userService;
    public ApplicationUI(UserService userService) {
        this.userService = userService;
        //Initializes FlatLaf Look and Feel
        initFlatLaf();

        //Card Controller Initialization
        ccInstance = new CardController(this);
        addCards();
        ccInstance.showCard("boot");

        //Default Operations
        setFavicon();
        setTitle("Blue Link");
        setSize(1080, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void initFlatLaf() {
        try {
            FlatIntelliJLaf.setup();
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
    }
    private void addCards() {
        //Boot Card
        final String bootString = "boot";
        BootUI bootUI = new BootUI();
        ccInstance.addCard(bootUI, bootString);

        //Login Card
        final String loginString = "login";
        LoginUI loginUI = new LoginUI(userService);
        ccInstance.addCard(loginUI, loginString);

        //Main Card
        final String mainString = "main";
        MainUI mainUI = new MainUI();
        ccInstance.addCard(mainUI, mainString);
    }
    private void setFavicon() {
        ImageIcon favicon = new ImageIcon("src/main/resources/static/blue-link-favicon.png");
        setIconImage(favicon.getImage());
    }
}
