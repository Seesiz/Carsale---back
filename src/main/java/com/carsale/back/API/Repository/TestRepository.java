package com.carsale.back.API.Repository;

import com.carsale.back.API.Model.Test;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends MongoRepository<Test,Integer> {
}
