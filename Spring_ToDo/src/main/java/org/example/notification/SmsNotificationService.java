package org.example.notification;


import org.springframework.stereotype.Component;

@Component
public class SmsNotificationService implements NotificationService {
    @Override
    public void sendNotification(String taskTitle, String message) {
        System.out.println("Sending SMS notification for task: " + taskTitle+" Message: " + message);
    }
}
