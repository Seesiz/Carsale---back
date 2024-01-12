package com.carsale.back.API.Controller;

import com.carsale.back.API.Model.Personne;
import com.carsale.back.API.Service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/personnes")
public class PersonneController {
    @Autowired
    private PersonneService personne_serv;

    @GetMapping()
    public List<Personne> getAll(){
        return  personne_serv.getListPersonne();
    }

    @PostMapping()
    public ResponseEntity<Object> ajoutPersonne(@RequestBody Personne p) {
        try {
            Personne addedPerson = personne_serv.ajoutPersonne(p);
            return new ResponseEntity<>(addedPerson, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public Personne modifierPersonne(@RequestBody Personne p){
        return personne_serv.modifierPersonne(p.getIdPersonne(),p);
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
