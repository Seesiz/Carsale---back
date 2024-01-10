package com.carsale.back.API.Repository;

import com.carsale.back.API.Model.Categorie;
import com.carsale.back.API.Model.Model;
import com.carsale.back.API.Model.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoitureRepository extends JpaRepository<Voiture,Integer> {
    List<Voiture> findByCategorie(Categorie c);
    List<Voiture> findByModel(Model m);
}
