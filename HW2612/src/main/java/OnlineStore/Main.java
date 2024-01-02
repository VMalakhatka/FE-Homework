package OnlineStore;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {


    public static void main(String[] args) {

        Store store = new Store();
        int corePoolSize = 5;
        int maxPoolSize = 10;
        long keepAliveTime = 5000;
        int orderId = 1;

        ThreadPoolExecutor orderExecutor = new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                keepAliveTime,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>()
        );

        ScheduledThreadPoolExecutor deliveryScheduler = new ScheduledThreadPoolExecutor(2);

        for (int i = 0; i < 20; i++) {
            orderExecutor.execute(new OrderProcessor(orderId++,store));
        }

        for (int i = 0; i < 20; i++) {
            deliveryScheduler.scheduleWithFixedDelay(new DeliveryTask(orderId++,store), 0, 5000, TimeUnit.MILLISECONDS);
        }

        orderExecutor.shutdown();

        deliveryScheduler.shutdown();
    }
}