package com.polywertz.bluelink;

import com.polywertz.bluelink.controller.UserService;
import com.polywertz.bluelink.ui.ApplicationUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

@SpringBootApplication
public class BlueLinkApplication {

    final static boolean loginUser = false;
    public static void main(String[] args) {
        // Start the Spring Boot application and get the context
        ConfigurableApplicationContext context = SpringApplication.run(BlueLinkApplication.class, args);
        UserService userService = context.getBean(UserService.class);
        SwingUtilities.invokeLater(() -> {
            ApplicationUI appUI = new ApplicationUI(userService, loginUser);
            appUI.setVisible(true);
        });
    }



}
