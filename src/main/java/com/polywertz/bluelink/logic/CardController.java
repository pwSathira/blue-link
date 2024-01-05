package com.polywertz.bluelink.logic;

import com.polywertz.bluelink.ui.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class CardController {
    private CardLayout cl;
    private JPanel cards;

    @Autowired
    private ApplicationContext context; // Autowired ApplicationContext

    public CardController(JFrame frame) {
        cl = new CardLayout();
        cards = new JPanel(cl);
        cards.setPreferredSize(frame.getContentPane().getSize());
        frame.getContentPane().add(cards);
    }
    // Add a new card
    public void addCard(JPanel panel, String name) {
        cards.add(panel, name);
    }

    // Show a specific card
    public void showCard(String name) {
        cl.show(cards, name);
    }

    public void addLoginCards() {
        // Retrieve UI components from Spring context
        MainUI mainUI = context.getBean(MainUI.class);
        ProfilesUI profilesUI = context.getBean(ProfilesUI.class);
        ChargesUI chargesUI = context.getBean(ChargesUI.class);
        SettingsUI settingsUI = context.getBean(SettingsUI.class);
        ReportUI reportUI = context.getBean(ReportUI.class);

        // Add them as cards
        addCard(mainUI, "main");
        addCard(profilesUI, "profiles");
        addCard(chargesUI, "charges");
        addCard(settingsUI, "settings");
        addCard(reportUI, "report");

        // Show the main card
        showCard("main");
    }

    public void addInitialCards() {
        BootUI bootUI = context.getBean(BootUI.class);
        LoginUI loginUI = context.getBean(LoginUI.class);

        addCard(bootUI, "boot");
        addCard(loginUI, "login");
    }
}
