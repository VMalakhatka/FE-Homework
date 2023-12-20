package consumerProducer;

import java.util.Arrays;
import java.util.List;

public class ProducerConsumerExample {
    public static void main(String[] args) throws InterruptedException {
        final int max_capacity = 10;
        Warehouse warehouse = new Warehouse(max_capacity);

        List<Thread> produsers =  Arrays.stream(new int[4]).mapToObj(t-> new Thread(new Producer(warehouse))).toList();
        produsers.stream().forEach(Thread::start);

        List<Thread> consumers =  Arrays.stream(new int[5]).mapToObj(t-> new Thread(new Consumer(warehouse))).toList();
        consumers.stream().forEach(Thread::start);

        for (Thread thread:produsers) thread.join();
        for (Thread thread:consumers) thread.join();

    }
}
