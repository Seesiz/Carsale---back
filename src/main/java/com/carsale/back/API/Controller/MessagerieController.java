package com.carsale.back.API.Controller;

import com.carsale.back.API.Model.Messagerie;
import com.carsale.back.API.Service.MessagerieService;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/messageries")
@CrossOrigin(origins = "*")
public class MessagerieController {

    private final MessagerieService messagerieService;

    public MessagerieController(MessagerieService messagerieService) {
        this.messagerieService = messagerieService;
    }


    @PostMapping
    public void insert(@RequestBody Messagerie messagerie){
        messagerieService.create(messagerie);
    }

    @GetMapping
    public List<Messagerie> retrieve(){
        return messagerieService.retrieve();
    }

    @PutMapping
    public void update(@RequestBody Messagerie messagerie){
        messagerieService.update(messagerie);
    }

    @DeleteMapping
    public void delete(@RequestBody Messagerie messagerie){
        messagerieService.delete(messagerie);
    }

}

