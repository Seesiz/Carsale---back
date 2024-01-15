package com.carsale.back.API.Controller;

import com.carsale.back.API.Model.Annonce;
import com.carsale.back.API.Service.AnnonceService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/annonces")
@CrossOrigin(origins = "*")
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
    public void valider(@PathParam("idAnnonce") String idAnnonce){
        annonceService.valider(idAnnonce);
    }

    @GetMapping("/invalide")
    public List<Annonce> invalide(){
        return annonceService.getInvalide();
    }

    @GetMapping("/valide")
    public List<Annonce> valide(){
        return annonceService.getValide();
    }

    @GetMapping("/favoris")
    public List<Annonce> favoris(@PathParam("idUser") int idUser){
        return annonceService.getFavorisFor(idUser);
    }

    @PostMapping("/favoriser")
    public void favoriser(@PathParam("idAnnonce")String idAnnonce,@PathParam("idUser")int idUser){
        annonceService.favoriser(idAnnonce,idUser);
    }

}

