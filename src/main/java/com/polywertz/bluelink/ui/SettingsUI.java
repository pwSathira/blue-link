package com.polywertz.bluelink.ui;

import com.polywertz.bluelink.controller.UserService;
import com.polywertz.bluelink.logic.CardController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class SettingsUI extends TemplateUI {

    @Autowired
    private UserService userService;

    @Autowired
    public SettingsUI(CardController ccInstance) {
        super(ccInstance); // Call the constructor of TemplateUI
    }

}
