package com.carsale.back.API.Model;

import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class StatutVoiture {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idStatut")
    private int idStatut;

    @ManyToOne
    @JoinColumn(name = "idVoiture", referencedColumnName = "idVoiture")
    private Voiture voiture;

    @Column(name = "dateStatut", columnDefinition = "date")
    private Date dateStatut;

    /*
    * (
	    10 en attente de validation
		20 En vente
		30 vendu
    * */
    private int statut;

    public void setDateStatut(Date dateStatut) {
        this.dateStatut = dateStatut;
    }

    public void setDateStatut(String dateStatut) throws java.text.ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateS = dateFormat.parse(dateStatut);
        this.dateStatut = dateS;
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

    public StatutVoiture(Voiture voutureSave, java.sql.Date date){
        setVoiture(voutureSave);
        setDateStatut(date);
    }

    public StatutVoiture(Voiture v, String date) throws Exception{
        setVoiture(v);
        setDateStatut(date);
    }


}
