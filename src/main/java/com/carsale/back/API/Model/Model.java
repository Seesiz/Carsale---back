package com.carsale.back.API.Model;

import jakarta.persistence.*;

@Entity
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idModel")
    private int idModel;

    @OneToOne
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
    public Model(int idModel,Marque marque,String designation){
        setIdModel(idModel);
        setMarque(marque);
        setDesignation(designation);
    }

    public Model(Marque marque,String designation){
        setMarque(marque);
        setDesignation(designation);
    }
}
