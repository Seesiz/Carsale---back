package com.carsale.back.API.Controller;

import com.carsale.back.API.Model.EtatVoiture;
import com.carsale.back.API.Model.Voiture;
import com.carsale.back.API.Repository.EtatVoitureRepository;
import com.carsale.back.API.Repository.VoitureRepository;
import com.carsale.back.API.Service.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/voitures")
public class VoitureController {
    @Autowired
    private VoitureService voiture_serv;
    //----Voiture en vente rehetra
    @GetMapping()
    public List<Voiture> getAll(){
        return voiture_serv.getAllVoiture();
    }

    @PostMapping()
    public Voiture ajoutVoiture(@RequestBody Voiture v){
        return voiture_serv.ajoutVoiture(v);
    }

    @PutMapping()
    public Voiture modifierVoiture(@RequestBody Voiture voiture){
        return voiture_serv.modifierVoiture(voiture.getIdVoiture(),voiture);
    }

    //-----------Filtre voiture en vente rehetra iany
    @GetMapping("/model/{idModel}")
    public  HashMap<String, Object> getByModel(@PathVariable int idModel){
        HashMap<String,Object> reponse = new HashMap<>();
        List<Voiture> list = voiture_serv.getVoitureByModel(idModel);
        if (list.size()>0){
            reponse.put("data",list);
            return reponse;
        }else {
            reponse.put("message","aucune voiture associer avec cette model");
            return reponse;
        }
    }

    @GetMapping("/categorie/{idCategorie}")
    public  HashMap<String,Object> getCategorie(@PathVariable int idCategorie){
        HashMap<String,Object> reponse = new HashMap<>();
        List<Voiture> list = voiture_serv.getVoitureByCategorie(idCategorie);
        if (list.size()>0){
            reponse.put("data",list);
            return reponse;
        }else {
            reponse.put("message","aucune voiture associer avec cet model");
            return reponse;
        }
    }

    @GetMapping("/marque/{idMarque}")
    public  HashMap<String, Object> getMarque(@PathVariable int idMarque){
        HashMap<String,Object> reponse = new HashMap<>();
        List<Voiture> list = voiture_serv.getVoitureByMarque(idMarque);
        if (list.size()>0){
            reponse.put("data",list);
            return reponse;
        }else {
            reponse.put("message","aucune voiture associer avec cet model");
            return reponse;
        }
    }

    @GetMapping("/prix/{prix1}/{prix2}")
    public  HashMap<String, Object> getPrix(@PathVariable double prix1, @PathVariable double prix2){
        HashMap<String,Object> reponse = new HashMap<>();
        List<Voiture> list = voiture_serv.getVoitureByPrix(prix1,prix2);
        if (list.size()>0){
            reponse.put("data",list);
            return reponse;
        }else {
            reponse.put("message","aucune voiture associer avec cet model");
            return reponse;
        }
    }

}
