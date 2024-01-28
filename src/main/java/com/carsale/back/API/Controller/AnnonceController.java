package com.carsale.back.API.Controller;

import com.carsale.back.API.Model.Annonce;
import com.carsale.back.API.Service.AnnonceService;
import jakarta.websocket.server.PathParam;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
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
    public HashMap<String,Object> insert(@RequestHeader String tokken, @RequestBody Annonce annonce){
        HashMap<String,Object> response = new HashMap<>();
        try {
            annonceService.create(annonce,tokken);
            response.put("message","Annonce inserer avec success.");
            response.put("statut",true);
        } catch (Exception e) {
            response.put("message",e.getMessage());
            response.put("statut",false);
        }
        return response;
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

    @GetMapping("/myannonce")
    public List<Annonce> myAnnonce(@PathParam("idUser") int idUser){
        return annonceService.myAnnonce(idUser);
    }

    @GetMapping("/favoris")
    public List<Annonce> favoris(@PathParam("idUser") int idUser){
        return annonceService.getFavorisFor(idUser);
    }

    @PutMapping("/favoriser")
    public void favoriser(@PathParam("idAnnonce")String idAnnonce,@PathParam("idUser")int idUser){
        annonceService.favoriser(idAnnonce,idUser);
    }

    @PutMapping("/defavoriser")
    public void defavoriser(@PathParam("idAnnonce")String idAnnonce,@PathParam("idUser")int idUser){
        annonceService.defavoriser(idAnnonce,idUser);
    }

    @PutMapping("/etat")
    public HashMap<String, Object> etat(@PathParam("idAnnonce") String idAnnonce, @PathParam("etat") int etat){
        HashMap<String,Object> response = new HashMap<>();
        try {
            annonceService.changerEtat(idAnnonce,etat);
            response.put("message","Changement etat success.");
            response.put("statut",true);
        } catch (Exception e) {
            response.put("message",e.getMessage());
            response.put("statut",false);
        }
        return response;
    }

}

