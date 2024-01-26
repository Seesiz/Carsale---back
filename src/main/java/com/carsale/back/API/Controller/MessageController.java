package com.carsale.back.API.Controller;

import com.carsale.back.API.Model.Annonce;
import com.carsale.back.API.Model.Message;
import com.carsale.back.API.Service.MessageService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;



@RestController
@RequestMapping("/messages")
@CrossOrigin(origins = "*")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }


    @PostMapping
    public HashMap<String,Object> insert(@RequestHeader String tokken, @RequestBody Message message){
        HashMap<String,Object> response = new HashMap<>();
        try {
            messageService.create(message,tokken);
            response.put("message","Message envoye avec success.");
            response.put("statut",true);
        } catch (Exception e) {
            response.put("message",e.getMessage());
            response.put("statut",false);
        }
        return response;
    }

    @GetMapping
    public List<Message> retrieve(){
        return messageService.retrieve();
    }

    @PutMapping
    public void update(@RequestBody Message message){
        messageService.update(message);
    }

    @DeleteMapping
    public void delete(@RequestBody Message message){
        messageService.delete(message);
    }

    @GetMapping("/contacts")
    public HashMap<String,Object> contacts(@PathParam("idUser") int idUser){
        HashMap<String,Object> response = new HashMap<>();
        response.put("contacts",messageService.getAllContact(idUser));
        return response;
    }

    @GetMapping("/entre")
    public HashMap<String,Object> entre(@PathParam("idUser") int idUser,@PathParam("idContact") int idContact){
        HashMap<String,Object> response = new HashMap<>();
        response.put("contacts",messageService.entre(idUser,idContact));
        return response;
    }

}

