package org.resources;

class Consumer implements Runnable {
    private final Warehouse warehouse;
    private final int consumerId;
    private final int consumerTime;

    public Consumer(Warehouse warehouse, int consumerId, int consumerTime) {
        this.warehouse = warehouse;
        this.consumerId = consumerId;
        this.consumerTime = consumerTime;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Resource resource = warehouse.consume(consumerId);
                Thread.sleep(consumerTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
