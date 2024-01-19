package org.example.pojo;

import org.example.interfaces.Message;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class EmailSender {
    Message message;

    public EmailSender(Message message) {
        this.message = message;
    }

    public void sendEmail(){
        System.out.println("Email отправлено "+message.makeMassage());
    }
}
