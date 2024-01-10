package com.carsale.back.API.Repository;

import com.carsale.back.API.Model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneRepository extends JpaRepository<Personne,Integer> {
    Personne findByMailAndMotDePass(String mail,String motDePass);
}
