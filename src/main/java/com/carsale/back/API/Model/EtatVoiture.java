package com.carsale.back.API.Model;

import jakarta.persistence.*;

@Entity
public class EtatVoiture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idEtat")
    private int idEtat;

    private String designation;

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }

    public int getIdEtat() {
        return idEtat;
    }

    public void setIdEtat(int idEtat) {
        this.idEtat = idEtat;
    }
    public EtatVoiture(){}
    public EtatVoiture(int idEtat){
        setIdEtat(idEtat);
    }
    public EtatVoiture(int idEtat, String designation){
        setIdEtat(idEtat);
        setDesignation(designation);
    }
    public EtatVoiture(String designation){
        setDesignation(designation);
    }
}
