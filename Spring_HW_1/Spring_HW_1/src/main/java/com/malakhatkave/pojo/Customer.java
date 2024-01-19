package com.malakhatkave.pojo;

import org.springframework.context.annotation.Scope;

import java.time.LocalDate;
import java.util.Date;

@Scope("prototype")
public class Customer {
    private String id;
    String name;
    LocalDate dateOfLastNotification;
    String phone;
    String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfLastNotification() {
        return dateOfLastNotification;
    }

    public void setDateOfLastNotification(LocalDate dateOfLastNotification) {
        this.dateOfLastNotification = dateOfLastNotification;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return (String) "Id "+id+" Name "+ name+" Data "+dateOfLastNotification+" Phone "+phone+" Email "+email;
    }
}
