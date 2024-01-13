package com.carsale.back.API.Repository;

import com.carsale.back.API.Model.StatutVoiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatutVoitureRepository extends JpaRepository<StatutVoiture,Integer> {
    @Query("SELECT sv FROM StatutVoiture sv WHERE sv.dateStatut IN (SELECT MAX(sv2.dateStatut) FROM StatutVoiture sv2 GROUP BY sv2.voiture)")
    List<StatutVoiture> findLatestStatusByVehicle();

    @Query("SELECT sv FROM StatutVoiture sv WHERE sv.dateStatut IN (SELECT MAX(sv2.dateStatut) FROM StatutVoiture sv2 GROUP BY sv2.voiture)")
    List<StatutVoiture> findLatestStatusByIdVehicle();
}
