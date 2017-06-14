package com.hedgo.jmssender.main;

import com.hedgo.jmssender.service.JMSSender;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Start do send JMS messages with Spring and Apache Active MQ!");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");
        JMSSender jmsSender = (JMSSender) context.getBean("JMSSender");
        takeCommandFromUser(jmsSender);
    }

    private static void takeCommandFromUser(JMSSender jmsSender) {
        Scanner reader = new Scanner(System.in);
        String userCommand;

        while (true) {
            System.out.print("Enter command [text_to_send]:[destination] > ");
            userCommand = reader.nextLine();

            if ("exit".equalsIgnoreCase(userCommand)) {
                break;
            }

            jmsSender.sendSth(userCommand);
        }
    }
}
