package com.carsale.back.API.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Entity
public class Voiture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idVoiture")
    private int idVoiture;

    /*
    * ito ilay tompony ilay voiture
    * */
    @ManyToOne
    @JoinColumn(name = "idPersonne", referencedColumnName = "idPersonne")
    private Personne personne;

    @OneToOne
    @JoinColumn(name = "idCategorie", referencedColumnName = "idCategorie")
    private Categorie categorie;

    @OneToOne
    @JoinColumn(name = "idModel", referencedColumnName = "idModel")
    private Model model;

    /*
    * ny tena mety eto atao minuscule daholo anamorana ny filtre
    * */
    private String couleur;

    /*
    * ito mila atao majuscule daholo
    * */
    private  String plaque;
    /*
    * EtatVoiture = 10 => neuf (vaovao)
    * EtatVoiture = 9 => comme neuf
    * EtatVoiture = 8 => misy kika
    * EtatVoiture = 0 => Efa tena ratsy be
    * */
    @ManyToOne
    @JoinColumn(name = "idEtat", referencedColumnName = "idEtat")
    private EtatVoiture EtatVoiture;

    @Column(columnDefinition = "numeric(15,2)")
    private double prix;

    public int getIdVoiture() {
        return idVoiture;
    }

    public void setIdVoiture(int idVoiture) {
        this.idVoiture = idVoiture;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getPlaque() {
        return plaque;
    }

    public void setPlaque(String plaque) {
        plaque = plaque.toUpperCase();
        this.plaque = plaque;
    }

    public EtatVoiture getEtat() {
        return EtatVoiture;
    }

    public void setEtat(EtatVoiture etat) {
        EtatVoiture = etat;
    }

    public double getPrix() {
        BigDecimal bigDecimalPrix = BigDecimal.valueOf(prix);
        bigDecimalPrix.setScale(2, RoundingMode.HALF_UP);
        double doubleValue = bigDecimalPrix.doubleValue();
        return doubleValue;
    }
    public void setPrix(double prix) {
        BigDecimal bigDecimalPrix = BigDecimal.valueOf(prix);
        bigDecimalPrix.setScale(2, RoundingMode.HALF_UP);
        double doubleValue = bigDecimalPrix.doubleValue();
        this.prix = doubleValue;
    }

    public Voiture(){}
    public Voiture(int idVoiture){
        setIdVoiture(idVoiture);
    }

    public Voiture(int idVoiture, Personne personne, Categorie categorie, Model model,
                   String couleur, String plaque, EtatVoiture etat,
                   double prix) {
        setIdVoiture(idVoiture);
        setPersonne(personne);
        setCategorie(categorie);
        setModel(model);
        setCouleur(couleur);
        setPlaque(plaque);
        setEtat(etat);
        setPrix(prix);
    }

    public Voiture(Personne personne, Categorie categorie, Model model,
                   String couleur, String plaque, EtatVoiture etat,
                   double prix) {
        setPersonne(personne);
        setCategorie(categorie);
        setModel(model);
        setCouleur(couleur);
        setPlaque(plaque);
        setEtat(etat);
        setPrix(prix);
    }
}
