package com.carsale.back.API.Repository;

import com.carsale.back.API.Model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategorieRepository extends JpaRepository<Categorie,Integer> {
    List<Categorie> findCategoriesByEtatCategorie(int etat);
}
