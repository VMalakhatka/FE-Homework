package com.malakhatkave.interfaces;

public interface SmsNotificationService {
    void sendSms(String phoneNumber, String message);
}