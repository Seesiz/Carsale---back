package com.carsale.back.API.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idModel")
    private int idModel;

    @OneToOne
    @JoinColumn(name = "idMarque", referencedColumnName = "idMarque")
    private Marque marque;

    @ManyToOne
    @JoinColumn(name = "idCategorie", referencedColumnName = "idCategorie")
    private Categorie categorie;
    private String designation;

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setIdModel(int idModel) {
        this.idModel = idModel;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public String getDesignation() {
        return designation;
    }

    public int getIdModel() {
        return idModel;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public Marque getMarque() {
        return marque;
    }

    public Model(){}
    public Model(int idModel){
        setIdModel(idModel);
    }
    public Model(int idModel,Marque marque,String designation,Categorie categorie){
        setIdModel(idModel);
        setMarque(marque);
        setDesignation(designation);
        setCategorie(categorie);
    }

    public Model(Marque marque,String designation,Categorie categorie){
        setMarque(marque);
        setDesignation(designation);
        setCategorie(categorie);
    }
}
