package com.carsale.back.API.Repository;

import com.carsale.back.API.Model.Personne;
import com.carsale.back.API.Model.Tokken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokkenRepository extends JpaRepository<Tokken,Integer> {
    public Tokken findByPersonne(Personne p);
    public Tokken findByValeurtokken(String valeur);
}
