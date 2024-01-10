package com.carsale.back.API.Service;

import com.carsale.back.API.Model.*;
import com.carsale.back.API.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VoitureService {
    @Autowired
    private VoitureRepository voiture_rep;

    @Autowired
    private MarqueRepository marque_rep;

    @Autowired
    private ModelRepository model_rep;

    @Autowired
    private CategorieRepository categorie_rep;

    @Autowired
    private PersonneRepository personne_rep;

    @Autowired
    private EtatVoitureRepository etatVoiture_rep;

    @Autowired
    private ModelRepository getModel_rep;

    public List<Voiture> getAllVoiture(){
        return voiture_rep.findAll();
    }

    public Voiture ajoutVoiture(Voiture v){
        Personne personne = personne_rep.findById(v.getPersonne().getIdPersonne()).get();
        Categorie categorie = categorie_rep.findById((v.getCategorie().getIdCategorie())).get();
        Model model = model_rep.findById(v.getModel().getIdModel()).get();
        Marque marque = marque_rep.findById(model.getMarque().getIdMarque()).get();
        EtatVoiture etat = etatVoiture_rep.findById(v.getEtat().getIdEtat()).get();
        model.setMarque(marque);
        v.setPersonne(personne);
        v.setCategorie(categorie);
        v.setModel(model);
        v.setEtat(etat);
        return voiture_rep.save(v);
    }

    public Voiture modifierVoiture(int idVoiture,Voiture v){
        Voiture voiture = voiture_rep.findById(idVoiture).map(
                voiture1 -> {
                    voiture1.setPersonne(v.getPersonne());
                    voiture1.setModel(v.getModel());
                    voiture1.setCategorie(v.getCategorie());
                    voiture1.setCouleur(v.getCouleur());
                    voiture1.setPlaque(v.getPlaque());
                    voiture1.setPrix(v.getPrix());
                    v.setEtat(v.getEtat());
                    return voiture1;
                }
        ).orElseThrow(()-> new RuntimeException("impossible de touver la voiture avec l'ID:"+idVoiture));
        return  voiture_rep.save(voiture);
    }

    //-----------Filtre
    public List<Voiture> getVoitureByModel(int idModel){
        Model model = model_rep.findById(idModel).orElseThrow(()-> new RuntimeException("Impossible de trouver le model associer ID:"+idModel));
        return voiture_rep.findByModel(model);
    }
    public List<Voiture> getVoitureByCategorie(int idCategorie){
        Categorie categorie = categorie_rep.findById(idCategorie).orElseThrow(()-> new RuntimeException("Impossible de trouver la categorie associer ID"+idCategorie));
        return voiture_rep.findByCategorie(categorie);
    }

    public List<Voiture> getVoitureByMarque(int idMarque){
        List<Voiture> reponse =new ArrayList<>();
        Marque m = marque_rep.findById(idMarque).orElseThrow(()-> new RuntimeException("Marque introuvable ID:"+idMarque));
        List<Model> model = model_rep.findByMarque(m);
        for (int i = 0; i < model.size(); i++) {
            reponse.addAll(getVoitureByModel(model.get(i).getIdModel()));
        }
        return reponse;
    }
}
