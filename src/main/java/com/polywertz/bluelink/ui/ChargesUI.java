package com.polywertz.bluelink.ui;

import com.polywertz.bluelink.controller.UserService;
import com.polywertz.bluelink.logic.CardController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChargesUI extends TemplateUI{
    @Autowired
    private UserService userService;
    @Autowired
    public ChargesUI(CardController ccInstance) {
        super(ccInstance);
    }
}
