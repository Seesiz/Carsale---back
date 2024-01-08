package com.carsale.back.API.Repository;

import com.carsale.back.API.Model.Marque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarqueRepository extends JpaRepository<Marque,Integer> {
}
