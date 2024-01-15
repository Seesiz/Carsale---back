package com.carsale.back.API.Model;

import java.util.Date;

public class Message {
    int idSender;
    Date dateEnvoye;
    Object content;

    public int getIdSender() {
        return idSender;
    }

    public void setIdSender(int idSender) {
        this.idSender = idSender;
    }

    public Date getDateEnvoye() {
        return dateEnvoye;
    }

    public void setDateEnvoye(Date dateEnvoye) {
        this.dateEnvoye = dateEnvoye;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
