package com.carsale.back.API.Service;

import com.carsale.back.API.Model.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompteService {
    @Autowired
    private com.carsale.back.API.Repository.CompteRepository compte_rep;

    public Compte ajoutCompte(Compte c){
        return compte_rep.save(c);
    }

    public List<Compte> getListComptes(){
        return  compte_rep.findAll();
    }

    public Compte modifierCompte(int idCompte, Compte c){
        Compte compte = compte_rep.findById(idCompte).map(
                compte1 -> {
                    compte1.setDesignation(c.getDesignation());
                    return compte1;
                }
        ).orElseThrow(() -> new RuntimeException("Impossible de trouver le compte avec l'ID : " + idCompte));
        return compte_rep.save(compte);
    }

}
