package com.carsale.back.API.Repository;

import com.carsale.back.API.Model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.carsale.back.API.Model.TokkenMobile;

@Repository
public interface TokkenMobileRepository extends JpaRepository<TokkenMobile,Integer> {
    TokkenMobile findByPersonne(Personne personne);
}
