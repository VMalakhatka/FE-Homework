package consumerProducer;

class Consumer implements Runnable {
    private Warehouse warehouse;

    public Consumer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 20; i++) {
                warehouse.getGoods();
                Thread.sleep(1300);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}