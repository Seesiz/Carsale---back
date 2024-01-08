package com.carsale.back.API.Model;

import jakarta.persistence.*;

@Entity
public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idMarque" )
    private int idMarque;

    private String designation;

    public void setIdMarque(int idMarque) {
        this.idMarque = idMarque;
    }
    public int getIdMarque() {
        return idMarque;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public String getDesignation() {
        return designation;
    }
    public Marque(){}
    public Marque(int idMarque,String designation){
        setIdMarque(idMarque);
        setDesignation(designation);
    }

    // ajout de Marque
    public Marque(String designation){
        setDesignation(designation);
    }

    //find by Id
    public Marque(int idMarque){
        setIdMarque(idMarque);
    }

}
