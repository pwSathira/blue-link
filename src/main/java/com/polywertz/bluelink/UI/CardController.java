package com.polywertz.bluelink.UI;

import javax.swing.*;

import java.awt.*;

public class CardController {
    private CardLayout cl;
    private JPanel cards;

    public CardController(JFrame frame) {
        cl = new CardLayout();
        cards = new JPanel(cl);

        cards.setPreferredSize(frame.getContentPane().getSize());

        // Add the cards panel to the frame
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
}
