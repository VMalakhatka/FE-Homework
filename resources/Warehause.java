package org.resources;

import java.util.LinkedList;
import java.util.List;

class Warehouse {
    private final List<Resource> storage = new LinkedList<>();
    private final int storageSize;

    public Warehouse(int storageSize) {
        this.storageSize = storageSize;
    }

    public synchronized void produce(Resource resource, int producerId) throws InterruptedException {
        while (storage.size() >= storageSize) {
            System.out.println("Producer " + producerId + " is waiting. Storage is full.");
            wait();
        }

        storage.add(resource);
        System.out.println(System.currentTimeMillis() + " - Producer " + producerId + " produced resource " + resource.getId() + ". Storage size: " + storage.size());
        notifyAll();
    }

    public synchronized Resource consume(int consumerId) throws InterruptedException {
        while (storage.isEmpty()) {
            System.out.println("Consumer " + consumerId + " is waiting. Storage is empty.");
            wait();
        }

        Resource resource = storage.remove(0);
        System.out.println(System.currentTimeMillis() + " - Consumer " + consumerId + " consumed resource " + resource.getId() + ". Storage size: " + storage.size());
        notifyAll();
        return resource;
    }
}
