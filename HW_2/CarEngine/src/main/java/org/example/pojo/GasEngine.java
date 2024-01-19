package org.example.pojo;

import org.example.interfaces.Engine;
import org.springframework.stereotype.Component;

import java.security.spec.ECField;
@Component
public class GasEngine implements Engine {
    @Override
    public void work() {
        System.out.println("//// !!!!Дырчит и потребляет топливо");
    }
}
