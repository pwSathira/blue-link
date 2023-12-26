package com.polywertz.bluelink.ui;

import com.polywertz.bluelink.controller.UserService;

public class MainUI extends TemplateUI {
    public MainUI(UserService userService) {
        super(userService); // Call the constructor of TemplateUI
        System.out.println(userService.getCurrentUser().getName());
    }

}
