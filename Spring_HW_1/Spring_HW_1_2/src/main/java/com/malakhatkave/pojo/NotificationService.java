package com.malakhatkave.pojo;

import com.malakhatkave.interfaces.EmailNotificationService;
import com.malakhatkave.interfaces.SmsNotificationService;

public class NotificationService {
    private SmsNotificationService smsNotificationService;
    private EmailNotificationService emailNotificationService;

    // Инжекция зависимостей через конструктор
    public NotificationService(SmsNotificationService smsNotificationService,
                               EmailNotificationService emailNotificationService) {
        this.smsNotificationService = smsNotificationService;
        this.emailNotificationService = emailNotificationService;
    }

    // Метод для отправки спама, делегирующий работу SMS и Email сервисам
    public void sendSpam(Customer customer) {
        // Проверка, прошло ли более 30 дней с последней отправки
        if (customer.daysSinceLastNotification() > 30) {
            smsNotificationService.sendSms(customer.getPhoneNumber(), "Spam SMS message");
            emailNotificationService.sendEmail(customer.getEmailAddress(), "Spam Email message");

            // Обновление времени последней отправки
            customer.updateLastNotificationTimestamp();
        }
    }
}
