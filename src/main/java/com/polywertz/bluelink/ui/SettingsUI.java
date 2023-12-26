package com.polywertz.bluelink.ui;

import com.polywertz.bluelink.controller.UserService;

public class SettingsUI extends TemplateUI {
    public SettingsUI(UserService userService) {
        super(userService); // Call the constructor of TemplateUI
        System.out.println("SettingsUI constructor");
    }

}
