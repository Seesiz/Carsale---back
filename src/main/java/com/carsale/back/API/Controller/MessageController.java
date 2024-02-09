package com.carsale.back.API.Controller;

import com.carsale.back.API.Model.Annonce;
import com.carsale.back.API.Model.Message;
import com.carsale.back.API.Model.NotificationMessageRequest;
import com.carsale.back.API.Model.TokkenMobile;
import com.carsale.back.API.Service.MessageService;
import com.carsale.back.API.Service.PushNotificationService;
import com.carsale.back.API.Service.TokkenMobileService;
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
    private final TokkenMobileService tokkenMobileService;
    private final PushNotificationService pushNotificationService;

    @Autowired
    public MessageController(MessageService messageService,TokkenMobileService tokkenMobileService,PushNotificationService pushNotificationService) {
        this.tokkenMobileService= tokkenMobileService;
        this.messageService = messageService;
        this.pushNotificationService = pushNotificationService;
    }


    @PostMapping
    public HashMap<String,Object> insert(@RequestHeader String tokken, @RequestBody Message message){
        HashMap<String,Object> response = new HashMap<>();
        try {
            messageService.create(message,tokken);
            response.put("message","Message envoye avec success.");
            response.put("statut",true);
            TokkenMobile tokkenMobile = tokkenMobileService.checkTokkenMobile(message.getReceiver());
            if (tokkenMobile!=null){
                NotificationMessageRequest request = new NotificationMessageRequest();
                request.setMessage(message.getSender().getPrenom() + " vous a envoyé un message");
                request.setTitle("Look at me !🥹");
                request.setToken(tokkenMobile.getValeurtokken());
                request.setTopic(message.getSender().getPrenom() + " vous a envoyé un message");
                pushNotificationService.sendPushNotificationToToken(request);
            }
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

