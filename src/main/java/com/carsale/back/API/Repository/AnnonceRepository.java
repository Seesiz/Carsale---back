package com.carsale.back.API.Repository;

import com.carsale.back.API.Model.Annonce;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnonceRepository extends MongoRepository<Annonce,Integer> {
}
