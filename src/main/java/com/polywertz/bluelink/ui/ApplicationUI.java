package com.polywertz.bluelink.ui;

import javax.swing.*;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.polywertz.bluelink.controller.UserService;
import com.polywertz.bluelink.logic.CardController;

public class ApplicationUI extends JFrame implements LoginSuccessListener{
    public static CardController ccInstance;
    private final UserService userService;
    public ApplicationUI(UserService userService) {
        this.userService = userService;
        //Initializes FlatLaf Look and Feel
        initFlatLaf();

        //Card Controller Initialization
        ccInstance = new CardController(this);
        addInitialCards();
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
    private void addInitialCards() {
        //Boot Card
        final String bootString = "boot";
        BootUI bootUI = new BootUI();
        ccInstance.addCard(bootUI, bootString);

        //Login Card
        final String loginString = "login";
        LoginUI loginUI = new LoginUI(userService, this);
        ccInstance.addCard(loginUI, loginString);
    }

    private void addUserDefinedCards() {
        //Add User Defined Cards Here
        //Main Card
        final String mainString = "main";
        MainUI mainUI = new MainUI(userService);
        ccInstance.addCard(mainUI, mainString);

        //Profiles Card
        final String profilesString = "profiles";
        ProfilesUI profilesUI = new ProfilesUI(userService);
        ccInstance.addCard(profilesUI, profilesString);

        //Charges Card
        final String chargesString = "charges";
        ChargesUI chargesUI = new ChargesUI(userService);
        ccInstance.addCard(chargesUI, chargesString);

        //Report Card
        final String reportString = "report";
        ReportUI reportUI = new ReportUI(userService);
        ccInstance.addCard(reportUI, reportString);

        //Settings Card
        final String settingsString = "settings";
        SettingsUI settingsUI = new SettingsUI(userService);
        ccInstance.addCard(settingsUI, settingsString);
    }
    private void setFavicon() {
        ImageIcon favicon = new ImageIcon("src/main/resources/static/blue-link-favicon.png");
        setIconImage(favicon.getImage());
    }

    @Override
    public void onLoginSuccess() {
        addUserDefinedCards();
        ccInstance.showCard("main");
    }
}
