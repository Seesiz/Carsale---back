package com.carsale.back.API.Service;

import com.carsale.back.API.Model.DetailVoiture;
import com.carsale.back.API.Repository.DetailVoitureRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class DetailVoitureService {
    private final DetailVoitureRepository detailVoitureRepository;

    @Autowired
    public DetailVoitureService(DetailVoitureRepository detailVoitureRepository) {
        this.detailVoitureRepository = detailVoitureRepository;
    }

    //Create
    @Transactional
    public DetailVoiture create(DetailVoiture detailVoiture){
        return detailVoitureRepository.save(detailVoiture);
    }

    //Retrieve
    public List<DetailVoiture> retrieve(){
        return (List<DetailVoiture>) detailVoitureRepository.findAll();
    }

    //Update
    @Transactional
    public DetailVoiture update(DetailVoiture detailVoiture){
        return detailVoitureRepository.save(detailVoiture);
    }

    //Delete
    @Transactional
    public void delete(DetailVoiture detailVoiture){
        detailVoitureRepository.delete(detailVoiture);
    }

    //By id
    public DetailVoiture byId(Integer id){
        return detailVoitureRepository.findById(id).get();
    }

}
