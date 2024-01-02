package org.ReadWrite;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class User implements Runnable {
    private static int userCount = 0;
    private int userId;
    private SharedDocument sharedDocument;

    public User(SharedDocument sharedDocument) {
        this.sharedDocument = sharedDocument;
        this.userId = ++userCount;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(3000));
            List<String> currentDocument = sharedDocument.readDocument();

            System.out.println("Пользователь " + userId + " Прочитал документ " + currentDocument);

            currentDocument.add("User " + userId + " добавил свои зменения.");
            sharedDocument.writeDocument(currentDocument);
            Thread.sleep(ThreadLocalRandom.current().nextInt(3000));

            System.out.println("Пользователь " + userId + " Внес изменения " + currentDocument);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
