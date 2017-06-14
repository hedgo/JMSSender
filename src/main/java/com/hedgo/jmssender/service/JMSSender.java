package com.hedgo.jmssender.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Scanner;

@Component
public class JMSSender {
    @Autowired private JmsOperations jmsTemplate;

    public void sendSth(String userCommand) {
        String[] commandPart = userCommand.split(":");
        String destination = "test01";

        if (commandPart.length==2) {
            destination = commandPart[1];
        }

        jmsTemplate.convertAndSend(destination, commandPart[0]);

        //2 WAY
//        jmsTemplate.convertAndSend("test01", new User("andrzej=" + s, 10001));

        //3 WAY
//     jmsTemplate.send("test01", new MessageCreator() {
//            public Message createMessage(Session session) throws JMSException {
//                return session.createTextMessage("halo??!");
//            }
//        });
    }
}
