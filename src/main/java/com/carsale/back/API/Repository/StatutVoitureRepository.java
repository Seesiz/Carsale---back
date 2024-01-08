package com.carsale.back.API.Repository;

import com.carsale.back.API.Model.StatutVoiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatutVoitureRepository extends JpaRepository<StatutVoiture,Integer> {
}
