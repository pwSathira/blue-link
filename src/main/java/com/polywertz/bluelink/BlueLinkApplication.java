package com.polywertz.bluelink;

import com.polywertz.bluelink.UI.MainWindow;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.awt.*;

@SpringBootApplication
public class BlueLinkApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlueLinkApplication.class, args);
        SwingUtilities.invokeLater(MainWindow::new);
    }
}
