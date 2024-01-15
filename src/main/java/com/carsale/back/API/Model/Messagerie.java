package com.carsale.back.API.Model;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document
public class Messagerie {
    @Id
    String id;
    Personne sender;
    List<Messages> messages;

    public Personne getSender() {
        return sender;
    }

    public void setSender(Personne sender) {
        this.sender = sender;
    }

    public List<Messages> getMessages() {
        return messages;
    }

    public void setMessages(List<Messages> messages) {
        this.messages = messages;
    }
}
