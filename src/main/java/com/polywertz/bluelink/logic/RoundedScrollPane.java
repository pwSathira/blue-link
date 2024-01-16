package com.polywertz.bluelink.logic;

import javax.swing.*;

public class RoundedScrollPane extends JScrollPane {
    public RoundedScrollPane(RoundedPanel roundedPanel) {
        super();
        setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        setOpaque(false);
        getViewport().setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder());
        setFocusable(false);
    }
}
