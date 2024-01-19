package org.example;

import org.example.pojo.ElectricCar;
import org.example.pojo.GasCar;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        ElectricCar electricCar = context.getBean("electricCar", ElectricCar.class);
        GasCar gasCar=context.getBean("gasCar",GasCar.class);
        electricCar.run();
        gasCar.run();
        context.close();
    }
}
