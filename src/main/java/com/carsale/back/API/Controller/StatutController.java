package com.carsale.back.API.Controller;

import com.carsale.back.API.Model.Statistique;
import com.carsale.back.API.Model.StatutVoiture;
import com.carsale.back.API.Model.Voiture;
import com.carsale.back.API.Repository.StatutVoitureRepository;
import com.carsale.back.API.Service.StatutVoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/statutVoitures")
@CrossOrigin(origins = "*")
public class StatutController {
    @Autowired
    private StatutVoitureService statutVoiture_ser;
    @Autowired
    private StatutVoitureRepository statutVoitureRepository;

    @GetMapping()
    public List<StatutVoiture> getAll(){
        return statutVoiture_ser.getListStatutVoiture();
    }

    @PutMapping()
    public StatutVoiture modifierStatut(@RequestBody StatutVoiture statutVoiture){

        return statutVoiture_ser.modifierStatutVoiture(statutVoiture.getIdStatut(),statutVoiture);
    }


    @PostMapping()
    public StatutVoiture ajoutStatus(@RequestBody StatutVoiture s){
        return statutVoiture_ser.ajoutStatutVoiture(s);
    }

    @GetMapping("/statistiqueanonce/{annee}")
    public ResponseEntity<Object> listVente(@PathVariable("annee") int annee){
        HashMap<String, Object> reponse = new HashMap<>();
        reponse.put("data", statutVoitureRepository.findStatutByYearAndStatus(annee,20));
        return new ResponseEntity<>(reponse, HttpStatus.OK);
    }

    @GetMapping("/statistiquevente/{annee}")
    public ResponseEntity<Object> listvente(@PathVariable("annee") int annee){
        HashMap<String, Object> reponse = new HashMap<>();
        reponse.put("data", statutVoitureRepository.findStatutByYearAndStatus(annee,30));
        return new ResponseEntity<>(reponse, HttpStatus.OK);
    }


    @GetMapping("/listAllAnnee")
    public List<Integer> allAnne(){
        return statutVoitureRepository.listAnne();
    }

}
