package com.carsale.back.API.Repository;

import com.carsale.back.API.Model.Marque;
import com.carsale.back.API.Model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model,Integer> {
    List<Model> findByMarque(Marque m);
}
