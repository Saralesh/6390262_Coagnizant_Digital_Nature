package com.library;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        WelcomeService service = (WelcomeService) context.getBean("welcomeService");
        service.greet();
    }
}

class WelcomeService {
    public void greet() {
        System.out.println("Welcome to the Library Management System!");
    }
}
