package com.carsale.back.API.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class StatutVoiture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idStatut")
    private int idStatut;

    @ManyToOne
    @JoinColumn(name = "idVoiture", referencedColumnName = "idVoiture")
    private Voiture voiture;

    @Column(name = "dateStatut" , columnDefinition = "date")
    private Date dateStatut;

    /*
    * (10-19 Vendu ,  20 -29 En atente de validation, )
	    10 vendu fa mbola tsy livré
		11 vendu sady livré
	    20: en attente de validation
    * */
    private int statut;


    public void setDateStatut(Date dateStatut) {
        this.dateStatut = dateStatut;
    }

    public void setIdStatut(int idStatut) {
        this.idStatut = idStatut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    public Date getDateStatut() {
        return dateStatut;
    }

    public int getIdStatut() {
        return idStatut;
    }

    public int getStatut() {
        return statut;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public StatutVoiture(){}
}
