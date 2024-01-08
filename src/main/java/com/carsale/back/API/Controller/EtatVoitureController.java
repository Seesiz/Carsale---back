package com.carsale.back.API.Controller;

import com.carsale.back.API.Model.EtatVoiture;
import com.carsale.back.API.Service.EtatVoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etats")
public class EtatVoitureController {
    @Autowired
    private EtatVoitureService etatVoiture_serv;

    @GetMapping()
    public List<EtatVoiture> getAll(){
        return etatVoiture_serv.getListEtatVoitures();
    }

    @PostMapping()
    public EtatVoiture ajoutEtatVoiture(@RequestBody EtatVoiture e){
        return  etatVoiture_serv.ajoutEtatVoiture(e);
    }

    @PutMapping()
    public EtatVoiture modifierEtatVoiture(@RequestBody EtatVoiture e){
        return etatVoiture_serv.modifierEtatVoiture(e.getIdEtat(),e);
    }
}
