package com.carsale.back.API.Model;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Message {
    @Id
    String id;
    Date dateEnvoye;
    Personne sender;
    Personne receiver;
    Object content;
    int etat;

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public Date getDateEnvoye() {
        return dateEnvoye;
    }

    public void setDateEnvoye(Date dateEnvoye) {
        this.dateEnvoye = dateEnvoye;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Personne getSender() {
        return sender;
    }

    public void setSender(Personne sender) throws Exception {
        sender.setMotDePass(null);
        this.sender = sender;
    }

    public Personne getReceiver() {
        return receiver;
    }

    public void setReceiver(Personne receiver) throws Exception {
        receiver.setMotDePass(null);
        this.receiver = receiver;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
