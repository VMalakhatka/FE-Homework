package org.exchenger;

import java.util.concurrent.Exchanger;

class DataProducer implements Runnable {
    private final Exchanger<String> exchanger;

    public DataProducer(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            String data = "Generated data";
            System.out.println("Данные сгенерированы: " + data);

            exchanger.exchange(data);

            System.out.println("Данные переданы и ждем обработки " );
            data = exchanger.exchange(null);
            System.out.println("Получили обработанные данные : "+data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}