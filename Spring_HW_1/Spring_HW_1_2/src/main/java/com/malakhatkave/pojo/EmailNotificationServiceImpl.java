package com.malakhatkave.pojo;

import com.malakhatkave.interfaces.EmailNotificationService;

public class EmailNotificationServiceImpl implements EmailNotificationService {
    @Override
    public void sendEmail(String emailAddress, String message) {
        //  отправки Email
        System.out.println("Sending Email to " + emailAddress + ": " + message);
    }
}