package org.example.pojo;

import org.example.interfaces.Message;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SmsSender {
    Message message;

    public SmsSender(Message message) {
        this.message = message;
    }

    public  void sendSMS(){
        System.out.println("SMS отправлено "+message.makeMassage());
    }
}
