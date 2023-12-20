package consumerProducer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Warehouse {
    private BlockingQueue<Integer> storage ;

    public Warehouse(int max_capacity) {
        this.storage = new LinkedBlockingQueue<>(max_capacity);
    }

    public void putGoods(int item) throws InterruptedException {
        // Добавляем элемент в склад (блокирующий вызов, если очередь полная)
        storage.put(item);
        System.out.println("Произв: "+Thread.currentThread().getId()+" Товар N" + item + ", Общее количество на складе: " + storage.size());
    }

    public void getGoods() throws InterruptedException {
        // Извлекаем элемент из склада (блокирующий вызов, если очередь пуста)
        int item = storage.take();
        System.out.println("Потребитель: "+Thread.currentThread().getId()+" Забрал товар N " + item + ", Общее количество на складе: " + storage.size());
    }
}

