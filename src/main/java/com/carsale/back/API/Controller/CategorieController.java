package com.carsale.back.API.Controller;

import com.carsale.back.API.Model.Categorie;
import com.carsale.back.API.Model.Tokken;
import com.carsale.back.API.Service.CategorieService;
import com.carsale.back.API.Service.TokkenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "*")
public class CategorieController {
    @Autowired
    private CategorieService categorie_serv;
    @Autowired
    private TokkenService tokken_serv;

    @GetMapping()
    public List<Categorie> getAll(){
        return categorie_serv.getListCategories();
    }

    @PostMapping()
    public Categorie ajoutCategori(@RequestBody Categorie c){
        return categorie_serv.ajoutCategorie(c);
    }

    @PutMapping()
    public ResponseEntity<Object> modifierCategorie(@RequestBody Categorie c,@RequestHeader("tokken") String tokken){
        HashMap<String,Object> reponse = new HashMap<>();
        try {
            Tokken t = tokken_serv.checTokken(tokken);
            if(tokken == null){
                reponse.put("message","Tokken invalide");
                return new ResponseEntity<>(reponse,HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
            }
            reponse.put("data",categorie_serv.modifierCategorie(c.getIdCategorie(),c));
            return new ResponseEntity<>(reponse,HttpStatus.OK);
        }catch (Exception e){
            reponse.put("message",e.getMessage());
            return new ResponseEntity<>(reponse,HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{idcategorie}")
    public ResponseEntity<Object> supprimerCategorie(@PathVariable int idcategorie,@RequestHeader("tokken") String tokken){
        HashMap<String,Object> reponse = new HashMap<>();
        try {
            Tokken t = tokken_serv.checTokken(tokken);
            if(tokken == null){
                reponse.put("message","Tokken invalide");
                return new ResponseEntity<>(reponse,HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
            }
            reponse.put("data",categorie_serv.supprimerCategorie(idcategorie));
            return new ResponseEntity<>(reponse,HttpStatus.OK);
        }catch (Exception e){
            reponse.put("message",e.getMessage());
            return new ResponseEntity<>(reponse,HttpStatus.BAD_REQUEST);
        }
    }
}
