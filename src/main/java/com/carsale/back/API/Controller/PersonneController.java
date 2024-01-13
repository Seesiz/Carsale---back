package com.carsale.back.API.Controller;

import com.carsale.back.API.Model.Personne;
import com.carsale.back.API.Model.Tokken;
import com.carsale.back.API.Repository.TokkenRepository;
import com.carsale.back.API.Service.PersonneService;
import com.carsale.back.API.Service.TokkenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/personnes")
@CrossOrigin(origins = "*")
public class PersonneController {
    @Autowired
    private PersonneService personne_serv;

    @Autowired
    private TokkenService tokken_ser;

    @GetMapping()
    public List<Personne> getAll(){
        return  personne_serv.getListPersonne();
    }

    @PostMapping()
    public HashMap<String,Object>  ajoutPersonne(@RequestBody Personne p) {
        HashMap<String,Object> reponse = new HashMap<>();
        try {
            reponse = personne_serv.ajoutPersonne(p);
            reponse.put("statut", true);
            return reponse;
        } catch (Exception e) {
            reponse.put("statut", false);
            reponse.put("message",e.getMessage());
            return reponse;
        }
    }

    @PutMapping
    public ResponseEntity<Object> modifierPersonne(@RequestBody Personne p,
                                     @RequestHeader("tokken") String tokken){
        HashMap<String,Object> reponse = new HashMap<>();
        try {
            Tokken t = tokken_ser.checTokken(tokken);
            if (t == null ){
                reponse.put("message","Tokken invalide ");
                return new ResponseEntity<>(reponse,HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            reponse.put("message",e.getMessage());
            return new ResponseEntity<>(reponse,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        reponse.put("data",personne_serv.modifierPersonne(p.getIdPersonne(),p));
        return new ResponseEntity<>( reponse,HttpStatus.OK);
    }

    @PostMapping("/login")
    public HashMap<String, Object> login(String mail, String motDePass){
        try {
            return personne_serv.login(mail,motDePass);
        }catch (Exception e){
            HashMap<String,Object> reponse = new HashMap<>();
            reponse.put("message",e.getMessage());
            return  reponse;
        }
    }

}
