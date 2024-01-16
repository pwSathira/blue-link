package com.polywertz.bluelink.logic;

import com.polywertz.bluelink.ui.SearchBarUI;

import javax.swing.*;
import java.awt.*;

public class ItemContainer extends RoundedPanel{
    private SearchBarUI.SearchCallback searchCallback;
    private RoundedPanel roundedScrollPanePanel;

    public ItemContainer(SearchBarUI.SearchCallback searchCallback) {
        super(20, new Color(0x379B8C));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.searchCallback = searchCallback;

        SearchBarUI searchBar = new SearchBarUI(this.searchCallback);
        add(searchBar); // Add the search bar to the top
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

}
