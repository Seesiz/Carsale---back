package com.carsale.back.API.Service;

import com.carsale.back.API.Model.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {
    @Autowired
    private com.carsale.back.API.Repository.CategorieRepository categorie_rep;

    public Categorie ajoutCategorie(Categorie c){
        c.setEtatCategorie(1);
        return categorie_rep.save(c);
    }

    public List<Categorie> getListCategories(){
        return  categorie_rep.findCategoriesByEtatCategorie(1);
    }

    public Categorie modifierCategorie(int idCatogorie,Categorie c){
        Categorie categorie = categorie_rep.findById(idCatogorie).map(
                cat->{
                    cat.setEtatCategorie(c.getEtatCategorie());
                    cat.setEtatCategorie(c.getEtatCategorie());
                    cat.setDesignation(c.getDesignation());
                    return cat;
                }
        ).orElseThrow(() -> new RuntimeException("Impossible de trouver la categorie avec l'ID : " + idCatogorie));
        return categorie_rep.save(categorie);
    }

    public Categorie supprimerCategorie(int idCategori){
        Categorie c= categorie_rep.findById(idCategori).map(
                cat -> {
                    cat.setEtatCategorie(0);
                    return cat;
                }
        ).orElseThrow(() -> new RuntimeException("Impossible de trouver la categorie avec l'ID : " + idCategori));
        return  categorie_rep.save(c);
    }
}
