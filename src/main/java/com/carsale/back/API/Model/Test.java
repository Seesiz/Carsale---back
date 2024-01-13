package com.carsale.back.API.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Test {

    @Id
    String id;
    String huhu;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHuhu() {
        return huhu;
    }

    public void setHuhu(String huhu) {
        this.huhu = huhu;
    }
}
