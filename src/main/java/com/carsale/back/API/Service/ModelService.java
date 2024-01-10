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
        Categorie c = categorie_rep.findById(model.getCategorie().getIdCategorie()).orElseThrow(()->new RuntimeException("Categorie not found"));
        Marque m = marque_rep.findById(model.getMarque().getIdMarque()).orElseThrow(()-> new RuntimeException("impossible de trouver la marque"));
        model.setMarque(m);
        model.setCategorie(c);
        return model_rep.save(model);
    }

    public List<Model> getListModel(){
        return model_rep.findAll();
    }

    public Model modifierModel(int idModel,Model mode){
        Marque marque = marque_rep.findById(mode.getMarque().getIdMarque()).get();
        Categorie categorie = categorie_rep.findById(mode.getCategorie().getIdCategorie()).get();
        Model m = model_rep.findById(idModel).map(
                model1 -> {
                    model1.setDesignation(mode.getDesignation());
                    model1.setMarque(marque);
                    model1.setCategorie(mode.getCategorie());
                    model1.setCategorie(categorie);
                    return model1;
                }
        ).orElseThrow(() -> new RuntimeException("impossible de trouver le model avec l'ID : "+idModel));

        return model_rep.save(m);
    }
}
