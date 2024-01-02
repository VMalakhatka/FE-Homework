package UniqueIdGenerator;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Thread client = new Thread(()->{
            long newId=0;
            for (int i = 0; i < 10; i++) {
                newId=UniqueIdGenerator.generateUniqueId();
                try {
                    Thread.sleep( ThreadLocalRandom.current().nextInt(1000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Клиент новое ИД "+newId);
            }
        });
        Thread product = new Thread(()->{
            long newId=0;
            for (int i = 0; i < 10; i++) {
                newId=UniqueIdGenerator.generateUniqueId();
                try {
                    Thread.sleep( ThreadLocalRandom.current().nextInt(1000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("--Продукт новое ИД "+newId);
            }
        });
        Thread task = new Thread(()->{
            long newId=0;
            for (int i = 0; i < 10; i++) {
                newId=UniqueIdGenerator.generateUniqueId();
                try {
                    Thread.sleep( ThreadLocalRandom.current().nextInt(1000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("-----Задача  новое ИД "+newId);
            }
        });
        client.start(); product.start(); task.start();
        try {
            client.join();product.join(); task.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
