package com.carsale.back.API.Controller;

import com.carsale.back.API.Model.Voiture;
import com.carsale.back.API.Service.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voitures")
public class VoitureController {
    @Autowired
    private VoitureService voiture_serv;

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
}
