package com.malakhatkave.pojo;

import java.time.LocalDate;
import java.util.Date;

public class Customer {
    private LocalDate date;
    private String phoneNumber;
    private String emailAddress;
    private long lastNotificationTimestamp;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Customer(String phoneNumber, String emailAddress) {
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public long daysSinceLastNotification() {

        return 31; // Вернем для примера 31 день
    }

    public void updateLastNotificationTimestamp() {
            date= LocalDate.now();
    }
}