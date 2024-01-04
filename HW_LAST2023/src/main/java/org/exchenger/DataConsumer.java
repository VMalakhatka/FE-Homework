package org.exchenger;

import java.util.concurrent.Exchanger;

class DataConsumer implements Runnable {
    private final Exchanger<String> exchanger;

    public DataConsumer(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            String receivedData = exchanger.exchange(null);

            System.out.println("Данные получены: " + receivedData);

            String processedData = "Data processed " + receivedData;
            System.out.println("Передал обработанные данные : " + processedData);

            exchanger.exchange(processedData);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
