package com.malakhatkave;

import com.malakhatkave.pojo.Customer;
import com.malakhatkave.pojo.NotificationService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;


public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext("aplicationContext.xml");
        Customer customer = context.getBean("customer",Customer.class);
        NotificationService notificationService = context.getBean("notificationService",
                                                        NotificationService.class);
       notificationService.sendSpam(customer);

    context.close();;


    }



}
