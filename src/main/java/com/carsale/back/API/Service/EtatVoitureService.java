package com.carsale.back.API.Service;

import com.carsale.back.API.Model.EtatVoiture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtatVoitureService {
    @Autowired
    private com.carsale.back.API.Repository.EtatVoitureRepository etat_voiture_rep;

    public EtatVoiture ajoutEtatVoiture(EtatVoiture e){
        return etat_voiture_rep.save(e);
    }

    public EtatVoiture modifierEtatVoiture(int idEtat,EtatVoiture e){
        EtatVoiture etatVoiture = etat_voiture_rep.findById(idEtat).map(
                etat -> {
                    etat.setDesignation(e.getDesignation());
                    return etat;
                }
        ).orElseThrow(() -> new RuntimeException("impossible de trouver l'etat avec l'ID : "+idEtat));
        return etat_voiture_rep.save(etatVoiture);
    }

    public List<EtatVoiture> getListEtatVoitures(){
        return etat_voiture_rep.findAll();
    }
}
