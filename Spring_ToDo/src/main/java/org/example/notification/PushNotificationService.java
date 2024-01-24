package org.example.notification;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PushNotificationService implements NotificationService {
    @Override
    public void sendNotification(String taskTitle, String message) {
        System.out.println("Sending push notification for task: " + taskTitle+"  Message: " + message);
    }
}
