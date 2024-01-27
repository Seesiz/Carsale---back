package com.carsale.back.API.Repository;

import com.carsale.back.API.Model.StatutVoiture;
import com.carsale.back.API.Model.Voiture;
import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StatutVoitureRepository extends JpaRepository<StatutVoiture,Integer> {
    @Query("SELECT sv FROM StatutVoiture sv WHERE sv.dateStatut IN (SELECT MAX(sv2.dateStatut) FROM StatutVoiture sv2 GROUP BY sv2.voiture)")
    List<StatutVoiture> findLatestStatusByVehicle();

    StatutVoiture findFirstByVoitureOrderByDateStatutDesc(Voiture voiture);

    @Query("SELECT sv FROM StatutVoiture sv WHERE sv.dateStatut IN (SELECT MAX(sv2.dateStatut) FROM StatutVoiture sv2 GROUP BY sv2.voiture)")
    List<StatutVoiture> findLatestStatusByIdVehicle();

    List<StatutVoiture> findByStatutOrderByDateStatutAsc(int statut);

    @Query(value = "SELECT sv FROM StatutVoiture sv WHERE EXTRACT(YEAR FROM sv.dateStatut) = :year AND sv.statut = :status", nativeQuery = false)
    List<StatutVoiture> findStatutByYearAndStatus(@Param("year") int year, @Param("status") int status);

    @Query(value = "SELECT extract(year from statut_voiture.date_statut) FROM statut_voiture GROUP BY extract(year from statut_voiture.date_statut)" , nativeQuery = true)
    List<Integer> listAnne();

}
