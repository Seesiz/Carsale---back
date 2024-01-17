package com.carsale.back.API.Service;

import com.carsale.back.API.Model.Annonce;
import com.carsale.back.API.Model.Personne;
import com.carsale.back.API.Repository.AnnonceRepository;
import com.carsale.back.API.Repository.PersonneRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnnonceService {
    private final AnnonceRepository annonceRepository;
    private final PersonneRepository personneRepository;

    @Autowired
    public AnnonceService(AnnonceRepository annonceRepository, PersonneRepository personneRepository) {
        this.annonceRepository = annonceRepository;
        this.personneRepository = personneRepository;
    }

    //Create
    @Transactional
    public Annonce create(Annonce annonce){
        annonce.setFavoriseur(new ArrayList<>());
        annonce.setEtat(0);
        annonce.setAnnonceur(getPersonne(annonce.getAnnonceur()));
        annonce.getVoiture().setPersonne(getPersonne(annonce.getAnnonceur()));
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
        update(annonce);
    }

    public List<Annonce> getInvalide(){
        return annonceRepository.findByEtat(0);
    }

    public List<Annonce> getValide(){
        return annonceRepository.findByEtat(10);
    }

    public List<Annonce> getFavorisFor(int idUser){
        return annonceRepository.getFavorisFor(idUser);
    }

    @Transactional
    public void favoriser(String idAnnonce,int idUser){
        Annonce annonce = byId(idAnnonce);
        annonce.getFavoriseur().add(idUser);
        update(annonce);
    }

}
