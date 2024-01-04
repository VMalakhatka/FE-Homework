package org.robot;

import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        final int numberOfRobots = 5;
        CyclicBarrier barrier = new CyclicBarrier(numberOfRobots);
        Arrays.stream(new int[numberOfRobots]).mapToObj(e->new Thread(new Robot(barrier))).forEach(Thread::start);
    }
}