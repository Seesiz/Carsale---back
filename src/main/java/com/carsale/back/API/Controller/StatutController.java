package com.carsale.back.API.Controller;

import com.carsale.back.API.Model.StatutVoiture;
import com.carsale.back.API.Model.Voiture;
import com.carsale.back.API.Service.StatutVoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statutVoitures")
@CrossOrigin(origins = "*")
public class StatutController {
    @Autowired
    private StatutVoitureService statutVoiture_ser;

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



}
