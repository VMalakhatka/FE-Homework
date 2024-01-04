package org.robot;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

class  Robot implements Runnable {
    private final CyclicBarrier barrier;

    public Robot(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+" Робот начал этап  "+ i);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(3000));
                System.out.println(Thread.currentThread().getName()+" Робот прошел этап  "+ i);
                barrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }

        }

    }
}