package com.carsale.back.API.Model;

import java.util.List;

public class Statistique {
    Object objet;
    List<Double> allvaleurs;

    public void setObjet(Object objet) {
        this.objet = objet;
    }

    public Object getObjet() {
        return objet;
    }

    public void setAllvaleurs(List<Double> allvaleurs) {
        this.allvaleurs = allvaleurs;
    }

    public List<Double> getAllvaleurs() {
        return allvaleurs;
    }

    public Statistique(){}
    public Statistique(Object objet,List<Double> allvaleurs){
        setObjet(objet);
        setAllvaleurs(allvaleurs);
    }
}
