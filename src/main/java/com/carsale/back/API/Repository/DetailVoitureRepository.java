package com.carsale.back.API.Repository;

import com.carsale.back.API.Model.DetailVoiture;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailVoitureRepository extends MongoRepository<DetailVoiture,Integer> {
}
