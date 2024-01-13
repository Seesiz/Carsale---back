package com.carsale.back.API.Service;

import com.carsale.back.API.Model.Test;
import com.carsale.back.API.Repository.TestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    private final TestRepository testRepository;

    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public List<Test> retrieve(){
        return testRepository.findAll();
    }

    public void create(Test test){
        testRepository.save(test);
    }
}
