package com.carsale.back.API.Controller;

import com.carsale.back.API.Model.Message;
import com.carsale.back.API.Service.MessageService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;



@RestController
@RequestMapping("/messages")

public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }


    @PostMapping
    public void insert(@RequestBody Message message){
        try {
            messageService.create(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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

