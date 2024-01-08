package com.carsale.back.API.Repository;

import com.carsale.back.API.Model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<Compte,Integer> {
}
