package com.carsale.back.API.Repository;

import com.carsale.back.API.Model.Message;
import com.carsale.back.API.Model.Personne;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MessageRepository extends MongoRepository<Message,String> {

    @Aggregation(pipeline = {
        "{ $match: { $or: [ { 'sender.idPersonne': ?0 }, { 'receiver.idPersonne': ?0 } ] } }",
        "{ $group: { _id: { $cond: { if: { $eq: ['$sender.idPersonne' , ?0 ] }, then: '$receiver.idPersonne', else: '$sender.idPersonne' } } } }",
        "{ $match: { _id: { $ne: ?0 } } }"
    })
    public List<Integer> getAllContact(int idUser);

    @Aggregation(pipeline = {
        "{ $match: { $or: [ {'sender.idPersonne': ?0, 'receiver.idPersonne': ?1},{'sender.idPersonne': ?1 , 'receiver.idPersonne': ?0 } ] } }",
        "{ $sort: { dateEnvoye: -1 } }",
        "{ $limit: 1 }"
    })
    public Message getLastMessage(int idUser,int idContact);

    @Aggregation(pipeline = {
            "{ $match: { $or: [ {'sender.idPersonne': ?0, 'receiver.idPersonne': ?1},{'sender.idPersonne': ?1 , 'receiver.idPersonne': ?0 } ] } }",
            "{ $sort: { dateEnvoye: 1 } }"
    })
    public List<Message> entre(int idUser,int idContact);

}
