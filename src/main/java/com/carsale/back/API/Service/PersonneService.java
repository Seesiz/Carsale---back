package com.carsale.back.API.Service;

import com.carsale.back.API.Model.Compte;
import com.carsale.back.API.Model.Personne;
import com.carsale.back.API.Model.Tokken;
import com.carsale.back.API.Repository.CompteRepository;
import com.carsale.back.API.Repository.PersonneRepository;
import com.carsale.back.API.Repository.TokkenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
public class PersonneService {
    @Autowired
    private PersonneRepository personne_rep;

    @Autowired
    private CompteRepository compte_rep;

    @Autowired
    private TokkenRepository tokken_rep;

    @Autowired
    private TokkenService tokken_serv;

    public HashMap<String,Object>  ajoutPersonne(Personne p) throws Exception{
        HashMap<String,Object> reponse = new HashMap<>();
        Compte c = compte_rep.findById(p.getCompte().getIdCompte()).orElseThrow(()-> new RuntimeException("Compte intouvable"));
        p.setCompte(c);
        //p.setMotDePass(p.getMotDePass());
        p = personne_rep.save(p);
        Tokken tokken= tokken_serv.creationTokken(p,new Date());
        reponse.put("data",p);
        reponse.put("tokken",tokken);
        return reponse;
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
                    try {
                        personne.setMotDePass(p.getMotDePass());
                    } catch (Exception e){
                        throw new RuntimeException(e);
                    }
                    personne.setCompte(c);
                    return personne;
                }
        ).orElseThrow(() -> new RuntimeException("impossible de trouver la personne avec l'ID : "+idPersonne));
        return personne_rep.save(pers);
    }

    public HashMap<String,Object> login(String mail, String motDePass) throws Exception{
        HashMap<String, Object> reponse = new HashMap<>();
        String motDePassCripte = new Personne().criptage(motDePass);
        Personne p =personne_rep.findByMail(mail);
        if(p==null){
            reponse.put("message","Personne introuvabe");
            return reponse;
        }
        if(!p.getMotDePass().equals(motDePassCripte)){
            reponse.put("message","Mot de passe incorrecte");
            return reponse;
        }
        Date d =new Date();
        Tokken  tokken = tokken_serv.creationTokken(p,d);
        reponse.put("tokken",tokken);
        reponse.put("data",p);
        return reponse;
    }
}
