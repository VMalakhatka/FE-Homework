package org.resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;


public class Main {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try (FileInputStream input =
                     //new FileInputStream("..//config.properties")
                     new FileInputStream("/Users/admin/Documents/Toleran/BackEnd/ProduserConsumer/src/main/java/org/resources/config.properties")
        ) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        int producerCount = 3;
//        int consumerCount = 2;
//        int producerTime = 1000;
//        int consumerTime = 1500;
//        int storageSize = 5;

        int producerCount = Integer.parseInt(properties.getProperty("producerCount"));
        int producerTime = Integer.parseInt(properties.getProperty("producerTime"));
        int consumerCount = Integer.parseInt(properties.getProperty("consumerCount"));
        int consumerTime = Integer.parseInt(properties.getProperty("consumerTime"));
        int storageSize = Integer.parseInt(properties.getProperty("storageSize"));

        System.out.println("Producer Count: " + producerCount);
        System.out.println("Producer Time: " + producerTime);
        System.out.println("Consumer Count: " + consumerCount);
        System.out.println("Consumer Time: " + consumerTime);
        System.out.println("Storage Size: " + storageSize);

        Warehouse warehouse = new Warehouse(storageSize);

        for (int i = 0; i < producerCount; i++) {
            Thread producerThread = new Thread(new Producer(warehouse, i + 1, producerTime));
            producerThread.start();
        }

        for (int i = 0; i < consumerCount; i++) {
            Thread consumerThread = new Thread(new Consumer(warehouse, i + 1, consumerTime));
            consumerThread.start();
        }
    }
}