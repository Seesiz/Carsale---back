package com.carsale.back.API.Controller;

import com.carsale.back.API.Model.Personne;
import com.carsale.back.API.Service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Personne ajoutPersonne(@RequestBody Personne p){
        return personne_serv.ajoutPersonne(p);
    }

    @PutMapping
    public Personne modifierPersonne(@RequestBody Personne p){
        return personne_serv.modifierPersonne(p.getIdPersonne(),p);
    }

    @PostMapping("/login")
    public Personne login(String mail,String motDePass){
        return personne_serv.login(mail,motDePass);
    }

}
