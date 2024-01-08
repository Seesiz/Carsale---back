package com.carsale.back.API.Controller;

import com.carsale.back.API.Model.Marque;
import com.carsale.back.API.Model.Model;
import com.carsale.back.API.Service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("models")
public class ModelController {
    @Autowired
    private ModelService model_serv;

    @GetMapping()
    public List<Model> getAll(){
        return model_serv.getListModel();
    }

    @PostMapping
    public Model ajoutModel(@RequestBody Model m){
        return model_serv.ajoutModel(m);
    }

    @PutMapping
    public Model modifierModel(@RequestBody Model m){
        return model_serv.modifierModel(m.getIdModel(),m);
    }
}
