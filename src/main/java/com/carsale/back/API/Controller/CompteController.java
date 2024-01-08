package com.carsale.back.API.Controller;

import com.carsale.back.API.Model.Categorie;
import com.carsale.back.API.Model.Compte;
import com.carsale.back.API.Service.CompteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comptes")
public class CompteController {
    @Autowired
    private CompteService compte_serv;

    @GetMapping()
    public List<Compte> getAll(){
        return compte_serv.getListComptes();
    }

    @PostMapping()
    public Compte ajoutCategori(@RequestBody Compte c){
        return compte_serv.ajoutCompte(c);
    }

    @PutMapping()
    public Compte modifierCategorie(@RequestBody Compte c){
        return compte_serv.modifierCompte(c.getIdCompte(),c);
    }

}
