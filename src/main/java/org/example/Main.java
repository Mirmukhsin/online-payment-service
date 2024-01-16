package org.example;

import org.example.config.ApplicationConfig;
import org.example.mainMenu.MainController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        MainController mainController = context.getBean(MainController.class);
        mainController.start();
    }
}