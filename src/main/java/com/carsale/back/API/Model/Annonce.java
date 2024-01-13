package com.carsale.back.API.Model;

import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int idAnnonce;
    Personne personne;
    Voiture voiture;
    List<DetailVoiture> detailVoitures;

    public int getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(int idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    public List<DetailVoiture> getDetailVoitures() {
        return detailVoitures;
    }

    public void setDetailVoitures(List<DetailVoiture> detailVoitures) {
        this.detailVoitures = detailVoitures;
    }
}
