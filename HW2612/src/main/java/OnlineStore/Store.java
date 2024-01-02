package OnlineStore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Store {
    private ConcurrentLinkedQueue<Integer> store;

    public Store() {
        this.store = new ConcurrentLinkedQueue();
    }

    public List<Integer> getReadyGoods() {
        List<Integer> delStore=new ArrayList<>();
        while (store.size()>0) delStore.add((Integer) store.poll());
        return delStore;
    }

    public void putGood(int good) {
        store.add(good);
    }
}
