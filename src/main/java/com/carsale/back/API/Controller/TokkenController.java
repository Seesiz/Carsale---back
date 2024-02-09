package com.carsale.back.API.Controller;

import com.carsale.back.API.Model.TokkenMobile;
import com.carsale.back.API.Service.TokkenMobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tokkenMobile")
@CrossOrigin(origins = "*")
public class TokkenController {
    @Autowired
    TokkenMobileService tokkenMobile_serv;

    @PostMapping()
    public TokkenMobile insertTokken(@RequestBody TokkenMobile tokkenMobile){
        return tokkenMobile_serv.insertTokkenMobile(tokkenMobile);
    }
}
