package com.polywertz.bluelink.ui;

import com.polywertz.bluelink.controller.UserService;

public class ReportUI extends TemplateUI {
    public ReportUI(UserService userService) {
        super(userService); // Call the constructor of TemplateUI
        System.out.println("ReportUI constructor");
    }
}
