package com.carsale.back.API.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;

@Entity
public class Caisse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_caisse;
    Date date_caisse;
    String id_annonce;
    double valeur;

    public Caisse(Annonce annonce) {
        long millis = System.currentTimeMillis();
        setDate_caisse(new Date(millis));
        setId_annonce(annonce.getId());
        setValeur((annonce.getVoiture().getPrix() * 5) / 100);
    }

    public int getId_caisse() {
        return id_caisse;
    }

    public void setId_caisse(int id_caisse) {
        this.id_caisse = id_caisse;
    }

    public Date getDate_caisse() {
        return date_caisse;
    }

    public void setDate_caisse(Date date_caisse) {
        this.date_caisse = date_caisse;
    }

    public String getId_annonce() {
        return id_annonce;
    }

    public void setId_annonce(String id_annonce) {
        this.id_annonce = id_annonce;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }
}
