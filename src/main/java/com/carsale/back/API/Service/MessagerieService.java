package com.carsale.back.API.Service;

import com.carsale.back.API.Model.Messagerie;
import com.carsale.back.API.Repository.MessagerieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MessagerieService {
    private final MessagerieRepository messagerieRepository;

    @Autowired
    public MessagerieService(MessagerieRepository messagerieRepository) {
        this.messagerieRepository = messagerieRepository;
    }

//Create
    @Transactional
    public Messagerie create(Messagerie messagerie){
        return messagerieRepository.save(messagerie);
    }

//Retrieve
    public List<Messagerie> retrieve(){
        return (List<Messagerie>) messagerieRepository.findAll();
    }

//Update
    @Transactional
    public Messagerie update(Messagerie messagerie){
        return messagerieRepository.save(messagerie);
    }

//Delete
    @Transactional
    public void delete(Messagerie messagerie){
        messagerieRepository.delete(messagerie);
    }

//By id
    public Messagerie byId(String id){
        return messagerieRepository.findById(id).get();
    }

}
