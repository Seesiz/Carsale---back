package com.carsale.back.API.Service;

import com.carsale.back.API.Model.Message;
import com.carsale.back.API.Model.Personne;
import com.carsale.back.API.Repository.MessageRepository;
import com.carsale.back.API.Repository.PersonneRepository;
import jakarta.transaction.Transactional;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;
    private final PersonneRepository personneRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository, PersonneRepository personneRepository) {
        this.messageRepository = messageRepository;
        this.personneRepository = personneRepository;
    }

//Create
    @Transactional
    public Message create(Message message) throws Exception {
        message.setSender(personneRepository.findById(message.getSender().getIdPersonne()).get());
        message.setReceiver(personneRepository.findById(message.getReceiver().getIdPersonne()).get());
        return messageRepository.save(message);
    }

//Retrieve
    public List<Message> retrieve(){
        return (List<Message>) messageRepository.findAll();
    }

//Update
    @Transactional
    public Message update(Message message){
        return messageRepository.save(message);
    }

//Delete
    @Transactional
    public void delete(Message message){
        messageRepository.delete(message);
    }

//By id
    public Message byId(String id){
        return messageRepository.findById(id).get();
    }


    public Message getLastMessage(int idUser,int idContact){
        return messageRepository.getLastMessage(idUser,idContact);
    }

    public List<Message> getAllContact(int idUser){
        List<Integer> idContacts = messageRepository.getAllContact(idUser);
        List<Message> contacts = new ArrayList<>();
        for (Integer idContact:idContacts) {
            Message last = getLastMessage(idUser,idContact);
            contacts.add(last);
        }
        return contacts;
    }

    public List<Message> entre(int idUser,int idContact){
        return messageRepository.entre(idUser,idContact);
    }

}
