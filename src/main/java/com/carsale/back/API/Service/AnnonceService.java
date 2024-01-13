package com.carsale.back.API.Service;

import com.carsale.back.API.Model.Annonce;
import com.carsale.back.API.Repository.AnnonceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AnnonceService {
    private final AnnonceRepository annonceRepository;

    @Autowired
    public AnnonceService(AnnonceRepository annonceRepository) {
        this.annonceRepository = annonceRepository;
    }

    //Create
    @Transactional
    public Annonce create(Annonce annonce){
        annonce.setEtat(0);
        return annonceRepository.save(annonce);
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
