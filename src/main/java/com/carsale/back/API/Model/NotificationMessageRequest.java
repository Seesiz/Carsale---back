package com.carsale.back.API.Model;
public class NotificationMessageRequest {
    private String title;
    private String message;
    private String topic;
    private String token;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getToken() {
        return token;
    }

    public String getMessage() {
        return message;
    }

    public String getTitle() {
        return title;
    }

    public String getTopic() {
        return topic;
    }

    public NotificationMessageRequest(String title, String message, String topic, String token) {
        this.title = title;
        this.message = message;
        this.topic = topic;
        this.token = token;
    }
    public NotificationMessageRequest() { }
}
