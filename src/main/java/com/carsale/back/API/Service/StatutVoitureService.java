package com.carsale.back.API.Service;

import com.carsale.back.API.Model.Personne;
import com.carsale.back.API.Model.StatutVoiture;
import com.carsale.back.API.Repository.StatutVoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StatutVoitureService {
    @Autowired
    private StatutVoitureRepository statutVoiture_rep;

    public List<StatutVoiture> getListStatutVoiture(){
        return statutVoiture_rep.findAll();
    }

    public StatutVoiture ajoutStatutVoiture(StatutVoiture s){
        return statutVoiture_rep.save(s);
    }

    public StatutVoiture modifierStatutVoiture(int idStatut, StatutVoiture s){
        StatutVoiture stat = statutVoiture_rep.findById(idStatut).map(
                status -> {
                    status.setStatut(s.getStatut());
                    status.setVoiture(s.getVoiture());
                    status.setDateStatut(s.getDateStatut());
                    return status;
                }
        ).orElseThrow(() -> new RuntimeException("impossible de trouver le statut avec l'ID : "+idStatut));

        return statutVoiture_rep.save(stat);
    }
}
