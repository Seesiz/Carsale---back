package com.carsale.back.API.Service;

import com.carsale.back.API.Model.Compte;
import com.carsale.back.API.Model.Marque;
import com.carsale.back.API.Model.Model;
import com.carsale.back.API.Model.Personne;
import com.carsale.back.API.Repository.CompteRepository;
import com.carsale.back.API.Repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonneService {
    @Autowired
    private PersonneRepository personne_rep;

    @Autowired
    private CompteRepository compte_rep;

    public Personne ajoutPersonne(Personne p){
        Compte c = compte_rep.findById(p.getCompte().getIdCompte()).orElseThrow(()-> new RuntimeException("Compte intouvable"));
        p.setCompte(c);
        return personne_rep.save(p);
    }

    public List<Personne> getListPersonne(){
        return personne_rep.findAll();
    }

    public Personne modifierPersonne(int idPersonne,Personne p){
        Compte c = compte_rep.findById(p.getCompte().getIdCompte()).get();
        Personne pers = personne_rep.findById(idPersonne).map(
                personne -> {
                    personne.setNom(p.getNom());
                    personne.setPrenom(p.getPrenom());
                    personne.setSexe(p.getSexe());
                    personne.setDateNaissance(p.getDateNaissance());
                    personne.setMail(p.getMail());
                    personne.setCin(p.getCin());
                    personne.setContact(p.getContact());
                    personne.setMotDePass(p.getMotDePass());
                    personne.setCompte(c);
                    return personne;
                }
        ).orElseThrow(() -> new RuntimeException("impossible de trouver la personne avec l'ID : "+idPersonne));
        return personne_rep.save(pers);
    }

    public Personne login(String mail,String motDePass){
        return  personne_rep.findByMailAndMotDePass(mail,motDePass);
    }
}
