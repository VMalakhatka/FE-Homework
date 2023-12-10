package org.resources;

class Producer implements Runnable {
    private final Warehouse warehouse;
    private final int producerId;
    private final int producerTime;

    public Producer(Warehouse warehouse, int producerId, int producerTime) {
        this.warehouse = warehouse;
        this.producerId = producerId;
        this.producerTime = producerTime;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Resource resource = new Resource();
                warehouse.produce(resource, producerId);
                Thread.sleep(producerTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
