package com.polywertz.bluelink;

import com.polywertz.bluelink.controller.UserService;
import com.polywertz.bluelink.ui.ApplicationUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;

@SpringBootApplication
public class BlueLinkApplication {
    public static void main(String[] args) {
        // Start the Spring Boot application and get the context
        ConfigurableApplicationContext context = SpringApplication.run(BlueLinkApplication.class, args);

        // Get the UserService bean from the Spring context
        UserService userService = context.getBean(UserService.class);

        // Pass the UserService to your Swing UI
        SwingUtilities.invokeLater(() -> {
            ApplicationUI appUI = new ApplicationUI(userService);
            appUI.setVisible(true);
        });
    }
}
