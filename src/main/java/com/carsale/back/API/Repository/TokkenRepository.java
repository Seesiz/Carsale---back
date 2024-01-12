package com.carsale.back.API.Repository;

import com.carsale.back.API.Model.Personne;
import com.carsale.back.API.Model.Tokken;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TokkenRepository extends JpaRepository<Tokken,Integer> {
    public Tokken findByPersonneAndValeurtokken(Personne personne,String valeurtokken) throws Exception;
    public Tokken findByValeurtokken(String valeurtokken) throws Exception;

    @Transactional
    @Modifying
    @Query(value = "delete from tokken where date_time_fin < now()" , nativeQuery = true)
    public void checkTokken();
}
