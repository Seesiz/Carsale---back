package com.carsale.back.API.Service;

import com.carsale.back.API.Model.*;
import com.carsale.back.API.Repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnnonceService {
    private final AnnonceRepository annonceRepository;
    private final PersonneRepository personneRepository;
    private final VoitureRepository voitureRepository;

    @Autowired
    private  StatutVoitureService statut_serv;
    private final TokkenService tokkenService;
    private final StatutVoitureRepository statutVoitureRepository;
    private final CaisseRepository caisseRepository;

    @Autowired
    public AnnonceService(AnnonceRepository annonceRepository, PersonneRepository personneRepository, VoitureRepository voitureRepository, TokkenService tokkenService,
                          StatutVoitureRepository statutVoitureRepository, CaisseRepository caisseRepository) {
        this.annonceRepository = annonceRepository;
        this.personneRepository = personneRepository;
        this.voitureRepository = voitureRepository;
        this.tokkenService = tokkenService;
        this.statutVoitureRepository = statutVoitureRepository;
        this.caisseRepository = caisseRepository;
    }

    //Create
    @Transactional
    public Annonce create(Annonce annonce,String valeurTokken) throws Exception {
        annonce.setFavoriseur(new ArrayList<>());
        annonce.setEtat(0);
        annonce.setAnnonceur(getPersonne(annonce.getAnnonceur()));
        annonce.getVoiture().setPersonne(getPersonne(annonce.getAnnonceur()));

        tokkenService.hasTokken(annonce.getAnnonceur(),valeurTokken);
        annonce.getVoiture().isdataCompleted();

        Voiture voutureSave = voitureRepository.save(annonce.getVoiture());

        // Obtenez la date et l'heure actuelles en millisecondes
        long millis = System.currentTimeMillis();
        StatutVoiture statutVoiture = new StatutVoiture(voutureSave,new Date(millis) );
        statutVoiture = statut_serv.ajoutStatutVoiture(statutVoiture);
        return annonceRepository.save(annonce);
    }


    public Personne getPersonne(Personne personne){
        return personneRepository.findById(personne.getIdPersonne()).get();
    }

    //Retrieve
    public List<Annonce> retrieve(){
        return (List<Annonce>) annonceRepository.findAll();
    }

    //Update
    @Transactional
    public Annonce update(Annonce annonce){
        return annonceRepository.save(annonce);
    }

    //Delete
    @Transactional
    public void delete(Annonce annonce){
        annonceRepository.delete(annonce);
    }

    //By id
    public Annonce byId(String id){
        return annonceRepository.findById(id).get();
    }

    @Transactional
    public void valider(String id){
        Annonce annonce = byId(id);
        annonce.setEtat(10);
        // Obtenez la date et l'heure actuelles en millisecondes
        long millis = System.currentTimeMillis();
        StatutVoiture statut = new StatutVoiture(annonce.getVoiture(),new Date(millis) );
        statut = statut_serv.validerStatuVoiture(statut);
        update(annonce);
    }

    @Transactional
    public void changerEtat(String id,int etat){
        Annonce annonce = byId(id);
        if(etat != 10 && etat != 0) {
            if(etat == 20){
                Caisse caisse = new Caisse(annonce);
                caisseRepository.save(caisse);
            }
            annonce.setEtat(etat);
            update(annonce);
        }
    }

    public List<Annonce> getInvalide(){
        return annonceRepository.findByEtat(0);
    }

    public List<Annonce> getValide(){
        return annonceRepository.findByEtat(10);
    }

    public List<Annonce> myAnnonce(int idUser){
        return annonceRepository.getMyAnnonce(idUser);
    }

    public List<Annonce> getFavorisFor(int idUser){
        return annonceRepository.getFavorisFor(idUser);
    }

    @Transactional
    public void favoriser(String idAnnonce,int idUser){
        Annonce annonce = byId(idAnnonce);
        for (int favoriseur:annonce.getFavoriseur()) {
            if(favoriseur == idUser) return;
        }
        annonce.getFavoriseur().add(idUser);
        update(annonce);
    }

    @Transactional
    public void defavoriser(String idAnnonce,int idUser){
        Annonce annonce = byId(idAnnonce);
        for (int i = 0; i < annonce.getFavoriseur().stream().count(); i++) {
            if(annonce.getFavoriseur().get(i) == idUser) annonce.getFavoriseur().remove(i);
        }
        update(annonce);
    }


}
