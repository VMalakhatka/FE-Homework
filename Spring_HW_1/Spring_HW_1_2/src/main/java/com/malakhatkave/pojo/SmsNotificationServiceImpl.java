package com.malakhatkave.pojo;


import com.malakhatkave.interfaces.SmsNotificationService;

public class SmsNotificationServiceImpl implements SmsNotificationService {
        @Override
        public void sendSms(String phoneNumber, String message) {
            // отправки SMS
            System.out.println("Sending SMS to " + phoneNumber + ": " + message);
        }
}

