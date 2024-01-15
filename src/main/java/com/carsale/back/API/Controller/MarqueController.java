package com.carsale.back.API.Controller;


import com.carsale.back.API.Model.Marque;
import com.carsale.back.API.Service.MarqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marques")
@CrossOrigin(origins = "*")
public class MarqueController {
    @Autowired
    private MarqueService marque_serv;

    @GetMapping()
    public List<Marque> getAll(){
        return marque_serv.getListMarque();
    }

    @PostMapping()
    public Marque ajoutMarque(@RequestBody Marque m){
        return  marque_serv.ajoutMarque(m);
    }

    @PutMapping
    public Marque modifierMarque(@RequestBody Marque m){
        return marque_serv.modifierMarque(m.getIdMarque(),m);
    }
}
