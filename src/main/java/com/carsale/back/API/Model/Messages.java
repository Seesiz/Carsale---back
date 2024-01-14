package com.carsale.back.API.Model;

import java.util.List;
public class Messages {
    Personne receiver;
    List<Message> message;

    public Personne getReceiver() {
        return receiver;
    }

    public void setReceiver(Personne receiver) {
        this.receiver = receiver;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }
}
