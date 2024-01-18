package com.polywertz.bluelink.logic;

import javax.swing.*;

public class ItemPane extends JScrollPane {
    public ItemPane(JPanel panel) {
        super(panel);
        setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        setOpaque(false);
        getViewport().setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder());
        setFocusable(false);
    }
}
