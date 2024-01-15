package com.carsale.back.API.Repository;

import com.carsale.back.API.Model.Messagerie;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface MessagerieRepository extends MongoRepository<Messagerie,String> {
    @Aggregation("{$sort:}")
    public List<Messagerie> byDateMessage();
}
