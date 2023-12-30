package com.polywertz.bluelink.ui;

import com.polywertz.bluelink.controller.UserService;
import com.polywertz.bluelink.logic.CardController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingsUI extends TemplateUI {

    @Autowired
    private UserService userService;

    @Autowired
    public SettingsUI(CardController cardController) {
        super(cardController); // Call the constructor of TemplateUI
        System.out.println("SettingsUI constructor");
    }

}
