package com.malakhatkave;

import com.malakhatkave.pojo.Customer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;


public class Main {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context=
                new ClassPathXmlApplicationContext("aplicationContext.xml");
        Customer customer1 = context.getBean("customer",Customer.class);
        Customer customer2 = context.getBean("customer",Customer.class);
        customer1.setId("1L");
        customer1.setName("Bob");
        customer1.setDateOfLastNotification(LocalDate.now());
        customer1.setPhone("+19138445656");
        customer1.setEmail(null);


        customer2.setId("2L");
        customer2.setName("Sarah");
        customer2.setDateOfLastNotification(LocalDate.of(2024,1,16));
        customer2.setPhone("+19158455617");
        customer2.setEmail("sarah-sweet@candy.com");

        System.out.println(customer1);
        System.out.println(customer2);


    }



}
