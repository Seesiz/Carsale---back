package com.carsale.back.API.Service;

import com.carsale.back.API.Model.Personne;
import com.carsale.back.API.Model.TokkenMobile;
import com.carsale.back.API.Repository.TestRepository;
import com.carsale.back.API.Repository.TokkenMobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokkenMobileService {
    @Autowired
    private  TokkenMobileRepository tokkenMobile_rep;

    public TokkenMobile insertTokkenMobile(TokkenMobile tokken){
        TokkenMobile saved =new TokkenMobile();
        saved = tokkenMobile_rep.findByPersonne(tokken.getPersonne());
        if(saved!= null){
            saved.setIdTokken(saved.getIdTokken());
        }
        saved = tokkenMobile_rep.save(tokken);
        return saved;
    }

    public TokkenMobile checkTokkenMobile(Personne personne){
        TokkenMobile rep = tokkenMobile_rep.findByPersonne(personne);
        return rep;
    }

}
