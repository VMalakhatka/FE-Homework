package org.example.pojo;

import org.example.interfaces.Engine;
import org.springframework.stereotype.Component;

@Component
public class ElectricEngine implements Engine {
    @Override
    public void work() {
        System.out.println(" Работает тихо на электричестве");
    }
}
