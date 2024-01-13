package com.carsale.back.API.Repository;

import com.carsale.back.API.Model.Annonce;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface AnnonceRepository extends MongoRepository<Annonce,String> {
    @Query("{etat:0}")
    public List<Annonce> getAllInvalide();
    public List<Annonce> findByEtat(int etat);
    @Query("{favoriseur:?0}")
    public List<Annonce> getFavorisFor(int iduser);
}
