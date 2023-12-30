package com.polywertz.bluelink;

import com.polywertz.bluelink.logic.CardController;
import com.polywertz.bluelink.ui.ApplicationUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BlueLinkApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BlueLinkApplication.class, args);
        ApplicationUI appUI = context.getBean(ApplicationUI.class);
        CardController cardController = context.getBean(CardController.class);
        appUI.postConstructInitialize(cardController);
    }
}
