package org.example.notification;

import org.springframework.stereotype.Component;

@Component
public class EmailNotificationService implements NotificationService {
    @Override
    public void sendNotification(String taskTitle, String message) {
        System.out.println("Sending email notification for task: " + taskTitle+" Message: " + message);
    }
}