package com.carsale.back.API.Controller;

import com.carsale.back.API.Model.Categorie;
import com.carsale.back.API.Service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategorieController {
    @Autowired
    private CategorieService categorie_serv;

    @GetMapping()
    public List<Categorie> getAll(){
        return categorie_serv.getListCategories();
    }

    @PostMapping()
    public Categorie ajoutCategori(@RequestBody Categorie c){
        return categorie_serv.ajoutCategorie(c);
    }

    @PutMapping("/{idCategorie}")
    public Categorie modifierCategorie(@RequestBody Categorie c){
        return categorie_serv.modifierCategorie(c.getIdCategorie(),c);
    }

    @DeleteMapping("/{idcategorie}")
    public Categorie supprimerCategorie(@PathVariable int idcategorie){
        return categorie_serv.supprimerCategorie(idcategorie);
    }
}
