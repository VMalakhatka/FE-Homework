package org.ReadWrite;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class SharedDocument {
    private List<String> document = new ArrayList<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public List<String> readDocument() {
        lock.readLock().lock();
        try {
            return new ArrayList<>(document);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void writeDocument(List<String> updatedDocument) {
        lock.writeLock().lock();
        try {
            document = new ArrayList<>(updatedDocument);
        } finally {
            lock.writeLock().unlock();
        }
    }
}
