package com.carsale.back.API.Controller;

import com.carsale.back.API.Model.Admin;
import com.carsale.back.API.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    private AdminService admin_ser;

    @GetMapping()
    public HashMap<String,Object> getAllValide(){
        HashMap<String,Object> reponse = new HashMap<>();
        List<Admin> list= admin_ser.getAdminValid();
        if (list.size()>0){
            reponse.put("data",list);
            return reponse;
        }
        reponse.put("message","aucun admin present");
        return reponse;
    }

    @PostMapping()
    public HashMap<String,Object> ajoutCompteAdmin(@RequestBody Admin a){
        HashMap<String, Object> reponse = new HashMap<>();
        Admin admin = admin_ser.ajoutCompteAdmin(a);
        if(admin != null){
            reponse.put("data",admin);
            return reponse;
        }
        reponse.put("message","erreur");
        return reponse ;
    }


}
