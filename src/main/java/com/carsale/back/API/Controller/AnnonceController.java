package com.carsale.back.API.Controller;

import com.carsale.back.API.Model.Annonce;
import com.carsale.back.API.Service.AnnonceService;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/annonces")

public class AnnonceController {

    private final AnnonceService annonceService;

    public AnnonceController(AnnonceService annonceService) {
        this.annonceService = annonceService;
    }


    @PostMapping
    public void insert(@RequestBody Annonce annonce){
        annonceService.create(annonce);
    }

    @GetMapping
    public List<Annonce> retrieve(){
        return annonceService.retrieve();
    }

    @PutMapping
    public void update(@RequestBody Annonce annonce){
        annonceService.update(annonce);
    }

    @DeleteMapping
    public void delete(@RequestBody Annonce annonce){
        annonceService.delete(annonce);
    }

    @PutMapping("/valider")
    public void valider(@RequestBody Annonce annonce){
        annonceService.valder(annonce);
    }

}

