package org.ReadWrite;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SharedDocument sharedDocument = new SharedDocument();
        List<Thread> threads = Arrays.stream(new int[10])
                .mapToObj(e-> new Thread(new User(sharedDocument)))
                .toList();
        threads.stream().forEach(Thread::start);
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        List<String> finalDocument = sharedDocument.readDocument();
        System.out.println("Послендние изменения : " + finalDocument);
    }
}