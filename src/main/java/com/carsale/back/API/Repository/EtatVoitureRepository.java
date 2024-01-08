package com.carsale.back.API.Repository;

import com.carsale.back.API.Model.EtatVoiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatVoitureRepository extends JpaRepository<EtatVoiture,Integer> {
}
