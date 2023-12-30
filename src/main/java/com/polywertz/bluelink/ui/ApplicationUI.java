package com.polywertz.bluelink.ui;

import javax.swing.*;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.polywertz.bluelink.logic.CardController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplicationUI extends JFrame {

    private CardController cardController;

    public ApplicationUI() {
        initFlatLaf();
        setFavicon();
        setTitle("Blue Link");
        setSize(1080, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void postConstructInitialize(CardController cardController) {
        // Use CardController to set up UI components
        cardController.addInitialCards();
        cardController.showCard("boot");
        setVisible(true);
    }

    private void initFlatLaf() {
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
    }

    private void setFavicon() {
        ImageIcon favicon = new ImageIcon("src/main/resources/static/blue-link-favicon.png");
        setIconImage(favicon.getImage());
    }

}
