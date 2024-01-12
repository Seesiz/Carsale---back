package com.carsale.back.API.Repository;

import com.carsale.back.API.Model.EtatVoiture;
import com.carsale.back.API.Model.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtatVoitureRepository extends JpaRepository<EtatVoiture,Integer> {
}
