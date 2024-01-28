package com.carsale.back.API.Controller;

import com.carsale.back.API.Model.Commission;
import com.carsale.back.API.Service.CommissionService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/commissions")
@CrossOrigin(origins = "*")
public class CommissionController {
    private final CommissionService commissionService;

    public CommissionController(CommissionService commissionService) {
        this.commissionService = commissionService;
    }

    @PostMapping("/insert")
    public void create(@PathParam("commission") double commission){
        commissionService.createorupdate(commission);
    }

    @GetMapping
    public Commission retrieve(){
        return commissionService.get();
    }

}
