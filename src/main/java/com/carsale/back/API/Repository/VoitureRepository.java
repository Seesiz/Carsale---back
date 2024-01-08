package com.carsale.back.API.Repository;

import com.carsale.back.API.Model.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture,Integer> {
}
