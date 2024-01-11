package com.carsale.back.API.Service;

import com.carsale.back.API.Model.Personne;
import com.carsale.back.API.Model.StatutVoiture;
import com.carsale.back.API.Model.Voiture;
import com.carsale.back.API.Repository.StatutVoitureRepository;
import com.carsale.back.API.Repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StatutVoitureService {
    @Autowired
    private StatutVoitureRepository statutVoiture_rep;

    @Autowired
    private VoitureRepository voiture_rep;

    /*
    * Maka ny statut ny voiture rehetra
    * */
    public List<StatutVoiture> getListStatutVoiture(){
        return statutVoiture_rep.findLatestStatusByVehicle();
    }

    /*
    * Maka ny statut voiture iray
    * */
    public StatutVoiture getStatut(int idvoiture){
        List<StatutVoiture> list = statutVoiture_rep.findLatestStatusByVehicle();
        StatutVoiture statutVoiture = null;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getVoiture().getIdVoiture() == idvoiture){
                statutVoiture = list.get(i);
            }
        }
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
    * 0 => en atente de validation
    * 1 => valider
    * 2 => vendu
    * Atao insert fona fa ny date no mitondra azy
    *  */
    public StatutVoiture ajoutStatutVoiture(StatutVoiture s){
        Voiture v= voiture_rep.findById(s.getVoiture().getIdVoiture()).get();
        s.setVoiture(v);
        s.setStatut(0);
        return statutVoiture_rep.save(s);
    }

    public StatutVoiture validerStatuVoiture(StatutVoiture s){
        Voiture v= voiture_rep.findById(s.getVoiture().getIdVoiture()).get();
        s.setVoiture(v);
        s.setStatut(1);
        return statutVoiture_rep.save(s);
    }

    public StatutVoiture vendre(StatutVoiture s){
        Voiture v= voiture_rep.findById(s.getVoiture().getIdVoiture()).get();
        s.setVoiture(v);
        s.setStatut(2);
        return statutVoiture_rep.save(s);
    }
}
