package com.polywertz.bluelink.ui;

import com.polywertz.bluelink.controller.UserService;

public class ProfilesUI extends TemplateUI{
    public ProfilesUI(UserService userService) {
        super(userService); // Call the constructor of TemplateUI
        System.out.println("ProfilesUI constructor");
    }
}
