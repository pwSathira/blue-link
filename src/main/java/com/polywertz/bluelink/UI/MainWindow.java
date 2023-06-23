package com.polywertz.bluelink.UI;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow() {
        CardController cardController = new CardController(this);
        addCards(cardController);
        setFavicon("src/main/resources/static/blue-link-favicon.png");
        setTitle("Blue Link");
        setSize(1080, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addCards(CardController cardController) {
        final String loginString = "login";
        LoginUI loginUI = new LoginUI();
        cardController.addCard(loginUI, loginString);
    }

    private void setFavicon(String path) {
        ImageIcon favicon = new ImageIcon(path);
        setIconImage(favicon.getImage());
    }
}
