package OnlineStore;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class DeliveryTask implements Runnable {
    private Store store;
    private int orderId;
    private List<Integer> delivery;

    public DeliveryTask(int orderId, Store store) {
        this.orderId = orderId;
        this.store=store;
    }

    @Override
    public void run() {
        delivery=store.getReadyGoods();
        if (delivery.size()>0) {
            System.out.println("----Доставка заказа " + delivery);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(2000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}