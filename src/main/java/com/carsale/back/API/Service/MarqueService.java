package com.carsale.back.API.Service;

import com.carsale.back.API.Model.EtatVoiture;
import com.carsale.back.API.Model.Marque;
import com.carsale.back.API.Repository.MarqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarqueService {
    @Autowired
    private MarqueRepository marque_rep;

    public Marque ajoutMarque(Marque m){
        return marque_rep.save(m);
    }
    public List<Marque> getListMarque(){
        return marque_rep.findAll();
    }

    public Marque modifierMarque(int idMarque,Marque m){
        Marque marque = marque_rep.findById(idMarque).map(
                marque1 -> {
                    marque1.setDesignation(m.getDesignation());
                    return marque1;
                }
        ).orElseThrow(() -> new RuntimeException("impossible de trouver la marque avec l'ID : "+idMarque));

        return marque_rep.save(marque);
    }
}
