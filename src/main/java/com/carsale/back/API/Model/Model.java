package com.carsale.back.API.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idModel")
    private int idModel;

    @ManyToOne
    @JoinColumn(name = "idMarque", referencedColumnName = "idMarque")
    private Marque marque;


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
    }

    public Model(Marque marque,String designation,Categorie categorie){
        setMarque(marque);
        setDesignation(designation);
    }
}
