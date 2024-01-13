package com.carsale.back.API.Model;

import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
public class Annonce {
    @Id
    String id;
    Date dateAnnonce;
    Personne annonceur;
    Voiture voiture;
    List<DetailVoiture> detailVoitures;
    List<String> photos;
    List<Integer> favoriseur;
    int etat;

    public List<Integer> getFavoriseur() {
        return favoriseur;
    }

    public void setFavoriseur(List<Integer> favoriseur) {
        this.favoriseur = favoriseur;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public Date getDateAnnonce() {
        return dateAnnonce;
    }

    public void setDateAnnonce(Date dateAnnonce) {
        this.dateAnnonce = dateAnnonce;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Personne getAnnonceur() {
        return annonceur;
    }

    public void setAnnonceur(Personne annonceur) {
        this.annonceur = annonceur;
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
