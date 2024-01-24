package org.example.connector;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Connector {

    private boolean isConnect;

    public Connector() {
        try {
            Thread.sleep(8000);
            this.isConnect = true;
        } catch (InterruptedException e) {
            this.isConnect=false;
            throw new RuntimeException(e);
        }
    }

    @PostConstruct
    public void initialize() {
        if(isConnect) System.out.println("Подключились к серверу..");
        else System.out.println("Ошибка подключения");
    }


    @PreDestroy
    public void close() {
        if (isConnect) System.out.println("Закрыли подключение к серверу..");
    }
}