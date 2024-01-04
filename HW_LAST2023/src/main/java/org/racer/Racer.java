package org.racer;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

class Racer implements Runnable {
    private final CountDownLatch startReady;

    public Racer(CountDownLatch preparationLatch) {
        this.startReady = preparationLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName()+"  Гонщик готовиться ");
            Thread.sleep(ThreadLocalRandom.current().nextInt(3000));

            System.out.println(Thread.currentThread().getName()+"  Гонщик готов к гонке ");
            startReady.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}