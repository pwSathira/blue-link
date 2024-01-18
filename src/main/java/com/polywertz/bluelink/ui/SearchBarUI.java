package com.polywertz.bluelink.ui;

import com.polywertz.bluelink.logic.IconRecolor;
import com.polywertz.bluelink.logic.RoundedPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class SearchBarUI extends JPanel {
    private final SearchCallback searchCallback;
    public interface SearchCallback {
        void onSearch(String searchTerm);
    }
    public SearchBarUI(SearchCallback searchCallback) {
        this.searchCallback = searchCallback;
        RoundedPanel searchPanel = new RoundedPanel(20, new Color(0xC1C9D4));
        searchPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));
        searchPanel.setPreferredSize(new Dimension(500, 50));
        searchPanel.setMaximumSize(new Dimension(500, 50));
        searchPanel.setMinimumSize(new Dimension(500, 50));

        JTextField searchField = new JTextField("Search...");
        searchField.setFont(new Font("Haettenschweiler", Font.PLAIN, 30));
        searchField.setForeground(Color.WHITE);
        searchField.setOpaque(false); // Optional: make it transparent
        searchField.setBorder(BorderFactory.createEmptyBorder()); // Optional: remove border
        searchField.setPreferredSize(new Dimension(400, 40)); // Set preferred size
        searchFieldListener(searchField);

        ImageIcon searchIcon = new ImageIcon("src/main/resources/static/searchbarui/searchicon.png");
        ImageIcon whiteIcon = IconRecolor.changeIconColor(searchIcon, Color.WHITE);
        whiteIcon.setImage(whiteIcon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        JLabel searchIconLabel = new JLabel(whiteIcon);
        searchIconLabel.setForeground(Color.white);

        searchPanel.add(searchIconLabel);
        searchPanel.add(searchField);
        add(searchPanel);

    }
    private void searchFieldListener(JTextField searchField) {
        searchField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                searchField.setText("");
            }
        });
        //Keylistener for enter key
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    if (searchCallback != null) {
                        searchCallback.onSearch(searchField.getText());
                    }
                }
            }
        });
    }

}

