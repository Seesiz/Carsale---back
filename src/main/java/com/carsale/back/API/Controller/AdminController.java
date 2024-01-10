package com.carsale.back.API.Controller;

import com.carsale.back.API.Model.Admin;
import com.carsale.back.API.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    private AdminRepository admin_rep;

    @PostMapping()
    public HashMap<String,Object> ajoutCompteAdmin(Admin a){
        HashMap<String, Object> reponse = new HashMap<>();
        Admin admin = admin_rep.save(a);
        if(admin != null){
            return (HashMap<String, Object>) reponse.put("data",admin);
        }
        return (HashMap<String, Object>) reponse.put("message","erreur");
    }
}
