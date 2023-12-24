package com.polywertz.bluelink.ui;

public class MainUI extends TemplateUI {
    public MainUI() {
        super(); // Call the constructor of TemplateUI
        customizeUI();
    }

    private void customizeUI() {
        label.setText("Welcome to Main UI!");
        button.setText("Main Action");
    }
}
