package org.racer;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {
        final int numberOfRacers = 5;
        CountDownLatch latch = new CountDownLatch(numberOfRacers);

        Arrays.stream(new int[numberOfRacers]).mapToObj(e->new Thread(new Racer(latch))).forEach(Thread::start);

        try {
            latch.await();
            System.out.println("Все готовы");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}