package com.polywertz.bluelink;

import com.polywertz.bluelink.ui.ApplicationUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class BlueLinkApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlueLinkApplication.class, args);
        SwingUtilities.invokeLater(ApplicationUI::new);
    }
}
