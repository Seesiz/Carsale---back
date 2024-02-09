package com.carsale.back.API.Model;

import jakarta.persistence.*;

@Entity

public class TokkenMobile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idTokken")
    private int idTokken;

    private String valeurtokken;
    @ManyToOne
    @JoinColumn(name = "idPersonne", referencedColumnName = "idPersonne")
    private Personne personne;

    public void setIdTokken(int idTokken) {
        this.idTokken = idTokken;
    }

    public void setValeurtokken(String valeurtokken) {
        this.valeurtokken = valeurtokken;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public String getValeurtokken() {
        return valeurtokken;
    }

    public int getIdTokken() {
        return idTokken;
    }

    public Personne getPersonne() {
        return personne;
    }
    public TokkenMobile(){}

    public TokkenMobile(int idTokken,String valeurtokken, Personne personne){
        setIdTokken(idTokken);
        setPersonne(personne);
        setValeurtokken(valeurtokken);
    }

}
