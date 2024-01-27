package com.carsale.back.API.Service;

import com.carsale.back.API.Model.Categorie;
import com.carsale.back.API.Model.Marque;
import com.carsale.back.API.Model.Model;
import com.carsale.back.API.Repository.CategorieRepository;
import com.carsale.back.API.Repository.MarqueRepository;
import com.carsale.back.API.Repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModelService {
    @Autowired
    private ModelRepository model_rep;

    @Autowired
    private MarqueRepository marque_rep;

    @Autowired
    private CategorieRepository categorie_rep;

    public Model ajoutModel(Model model){
        Marque m = marque_rep.findById(model.getMarque().getIdMarque()).orElseThrow(()-> new RuntimeException("impossible de trouver la marque"));
        model.setMarque(m);
        return model_rep.save(model);
    }

    public List<Model> getListModel(){
        return model_rep.findAll();
    }

    public Model modifierModel(int idModel,Model mode){
        Marque marque = marque_rep.findById(mode.getMarque().getIdMarque()).get();
        Model m = model_rep.findById(idModel).map(
                model1 -> {
                    model1.setDesignation(mode.getDesignation());
                    model1.setMarque(marque);
                    return model1;
                }
        ).orElseThrow(() -> new RuntimeException("impossible de trouver le model avec l'ID : "+idModel));

        return model_rep.save(m);
    }
}
