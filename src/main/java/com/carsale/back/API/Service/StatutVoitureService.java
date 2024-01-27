package com.carsale.back.API.Service;

import com.carsale.back.API.Model.Personne;
import com.carsale.back.API.Model.Statistique;
import com.carsale.back.API.Model.StatutVoiture;
import com.carsale.back.API.Model.Voiture;
import com.carsale.back.API.Repository.StatutVoitureRepository;
import com.carsale.back.API.Repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class StatutVoitureService {
    @Autowired
    private StatutVoitureRepository statutVoiture_rep;

    @Autowired
    private VoitureRepository voiture_rep;

    /*
    * Maka ny statut ny voiture rehetra
    * */
    public List<StatutVoiture> getListStatutVoiture(){
        return statutVoiture_rep.findAll();
    }

    /*
    * Maka ny statut voiture iray
    * */
    public StatutVoiture getStatut(int idvoiture){
        Voiture voiture = voiture_rep.findById(idvoiture).get();
        StatutVoiture statutVoiture = statutVoiture_rep.findFirstByVoitureOrderByDateStatutDesc(voiture);
        return statutVoiture;
    }



    public StatutVoiture modifierStatutVoiture(int idStatut, StatutVoiture s){
        Voiture v= voiture_rep.findById(s.getVoiture().getIdVoiture()).get();
        StatutVoiture stat = statutVoiture_rep.findById(idStatut).map(
                status -> {
                    status.setStatut(s.getStatut());
                    status.setVoiture(v);
                    status.setDateStatut(s.getDateStatut());
                    return status;
                }
        ).orElseThrow(() -> new RuntimeException("impossible de trouver le statut avec l'ID : "+idStatut));

        return statutVoiture_rep.save(stat);
    }

    /*
    * Statut voiture :
    * 10 => en atente de validation
    * 20 => valider
    * 30 => vendu
    * Atao insert fona fa ny date no mitondra azy
    *  */
    public StatutVoiture ajoutStatutVoiture(StatutVoiture s){
        Voiture v= voiture_rep.findById(s.getVoiture().getIdVoiture()).get();
        s.setVoiture(v);
        s.setStatut(10);
        return statutVoiture_rep.save(s);
    }

    public StatutVoiture validerStatuVoiture(StatutVoiture s){
        Voiture v= voiture_rep.findById(s.getVoiture().getIdVoiture()).get();
        s.setVoiture(v);
        s.setStatut(20);
        return statutVoiture_rep.save(s);
    }

    public StatutVoiture vendre(StatutVoiture s){
        Voiture v= voiture_rep.findById(s.getVoiture().getIdVoiture()).get();
        s.setVoiture(v);
        s.setStatut(30);
        return statutVoiture_rep.save(s);
    }



}
