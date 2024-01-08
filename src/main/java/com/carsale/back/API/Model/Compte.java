package com.carsale.back.API.Model;

import jakarta.persistence.*;

@Entity
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "idCompte")
    private int idCompte;

    private String designation;

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }

    public String getDesignation() {
        return designation;
    }

    public int getIdCompte() {
        return idCompte;
    }
}
