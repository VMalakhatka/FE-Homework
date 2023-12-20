package org.example.genrandominthread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThread {
    private static final int NUM_TREAD=10;
    private static final int TARGET=1000_000;
    private static AtomicInteger sharedVariable = new AtomicInteger(0);
    private static AtomicBoolean flag =new AtomicBoolean(false);
    public static void main(String[] args) throws InterruptedException {
       List<Thread> threads = Arrays.stream(new int[NUM_TREAD]).mapToObj(t->new Thread(()->{
             int random;
             while (!flag.get()){
                 random = ThreadLocalRandom.current().nextInt(1000);
                 try {
                     Thread.sleep(random);
                 } catch (InterruptedException e) {
                     throw new RuntimeException(e);
                 }
                 if(sharedVariable.get()>TARGET) {flag.set(true); random=0;}
                 else sharedVariable.addAndGet(random);
                 System.out.println("Thread "+Thread.currentThread().getId()+" add : "+random+" Summ : "+sharedVariable);
             }
         })).toList();
        threads.stream().forEach(Thread::start);
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(sharedVariable.get());
    }
}