package OnlineStore;

import java.util.concurrent.ThreadLocalRandom;

class OrderProcessor implements Runnable {
    private Store store;
    private int orderId;

    public OrderProcessor(int orderId, Store store) {
        this.orderId = orderId;
        this.store=store;
    }

    @Override
    public void run() {
        store.putGood(orderId);
        System.out.println("Обработка заказа " + orderId);
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(2000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}