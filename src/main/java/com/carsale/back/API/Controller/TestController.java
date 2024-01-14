package com.carsale.back.API.Controller;

import com.carsale.back.API.Model.Test;
import com.carsale.back.API.Service.TestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/tests")
@CrossOrigin(origins = "*")
public class TestController {
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping
    public List<Test> retrieve(){
        return testService.retrieve();
    }

    @PostMapping
    public void create(@RequestBody Test test){
        testService.create(test);
    }
}
