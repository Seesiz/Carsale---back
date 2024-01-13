package com.carsale.back.API.Model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class DetailVoiture {
    int idVoiture;
    String designation;
    Object valeur;

    public int getIdVoiture() {
        return idVoiture;
    }

    public void setIdVoiture(int idVoiture) {
        this.idVoiture = idVoiture;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Object getValeur() {
        return valeur;
    }

    public void setValeur(Object valeur) {
        this.valeur = valeur;
    }
}
