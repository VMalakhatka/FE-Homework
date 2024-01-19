package org.example;

import org.example.pojo.EmailSender;
import org.example.pojo.MessageGenerator;
import org.example.pojo.SmsSender;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");


        for (int i = 0; i < 10; i++) {
            SmsSender smsSender = context.getBean("smsSender", SmsSender.class);
            EmailSender emailSender=context.getBean("emailSender",EmailSender.class);
            smsSender.sendSMS();
            emailSender.sendEmail();

        }

        context.close();
    }
}
