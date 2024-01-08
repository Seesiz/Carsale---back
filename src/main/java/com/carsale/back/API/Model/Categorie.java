package com.carsale.back.API.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "Categorie")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCategorie")
    private int idCategorie;

    private String designation;
    /*
    * refa 1 ny etat de mbola misy
    * refa 0 ny etat de supprimer
    * */
    @ColumnDefault("1")
    private int etatCategorie;

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public String getDesignation() {
        return designation;
    }

    public void setEtatCategorie(int etatCategorie) {
        this.etatCategorie = etatCategorie;
    }

    public int getEtatCategorie() {
        return etatCategorie;
    }

    public Categorie(){}

    public Categorie(int idCategorie, String designation, int etatCategori) {
        setIdCategorie(idCategorie);
        setDesignation(designation);
        setEtatCategorie(etatCategori);
    }
    public Categorie(String designation, int etatCategori) {
        setIdCategorie(idCategorie);
        setDesignation(designation);
        setEtatCategorie(etatCategori);
    }
}
