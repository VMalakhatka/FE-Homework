package org.example.pojo;

import org.example.interfaces.Message;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
@Scope("prototype")
public class MessageGenerator implements Message {
    @Override
    public String makeMassage() {   
        return "New message" + LocalDateTime.now();
    }
}
