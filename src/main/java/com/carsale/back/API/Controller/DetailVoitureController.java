package com.carsale.back.API.Controller;

import com.carsale.back.API.Model.DetailVoiture;
import com.carsale.back.API.Service.DetailVoitureService;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/detailVoitures")

public class DetailVoitureController {

    private final DetailVoitureService detailVoitureService;

    public DetailVoitureController(DetailVoitureService detailVoitureService) {
        this.detailVoitureService = detailVoitureService;
    }


    @PostMapping
    public void insert(@RequestBody DetailVoiture detailVoiture){
        detailVoitureService.create(detailVoiture);
    }

    @GetMapping
    public List<DetailVoiture> retrieve(){
        return detailVoitureService.retrieve();
    }

    @PutMapping
    public void update(@RequestBody DetailVoiture detailVoiture){
        detailVoitureService.update(detailVoiture);
    }

    @DeleteMapping
    public void delete(@RequestBody DetailVoiture detailVoiture){
        detailVoitureService.delete(detailVoiture);
    }

}

