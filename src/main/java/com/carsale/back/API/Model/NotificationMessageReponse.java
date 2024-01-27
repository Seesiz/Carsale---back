package com.carsale.back.API.Model;
public class NotificationMessageReponse {
    private int status;
    private String message;
    public NotificationMessageReponse() { }

    public NotificationMessageReponse(int status, String message) {
        this.status = status;
        this.message = message;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
