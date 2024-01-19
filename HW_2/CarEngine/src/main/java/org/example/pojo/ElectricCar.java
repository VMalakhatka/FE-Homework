package org.example.pojo;

import org.example.interfaces.Engine;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ElectricCar {
    Engine engine;

    public ElectricCar(@Qualifier("electricEngine") Engine engine) {
        this.engine = engine;
    }

    public void run(){
        engine.work();
    }

}
