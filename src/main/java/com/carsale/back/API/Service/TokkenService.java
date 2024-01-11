package com.carsale.back.API.Service;

import com.carsale.back.API.Model.Personne;
import com.carsale.back.API.Model.Tokken;
import com.carsale.back.API.Repository.TokkenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokkenService {
    @Autowired
    private TokkenRepository tokken_rep;

    public Tokken creationTokken(Personne p, Date dateTimeDebut) throws Exception{
        Tokken t= new Tokken(p,dateTimeDebut);
        return tokken_rep.save(t);
    }

    public Tokken checkTokken(Personne p) throws Exception{
        Tokken t =tokken_rep.findByPersonne(p);
        return t;
    }

    public Tokken remouveTokken(Personne p) throws Exception{
        Tokken t =tokken_rep.findByPersonne(p);
        tokken_rep.delete(t);
        return t;
    }
}
