package org.example.pojo;

import org.example.interfaces.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class EmailSender {
    Message message;
@Autowired
    public EmailSender(Message message) {
        this.message = message;
    }

    public void sendEmail(){
        System.out.println("Email отправлено "+message.makeMassage());
    }
}
