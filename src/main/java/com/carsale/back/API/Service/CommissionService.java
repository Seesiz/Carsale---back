package com.carsale.back.API.Service;

import com.carsale.back.API.Model.Commission;
import com.carsale.back.API.Repository.CommissionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommissionService {
    private final CommissionRepository commissionRepository;

    public CommissionService(CommissionRepository commissionRepository) {
        this.commissionRepository = commissionRepository;
    }

    public Commission get(){
        return commissionRepository.findById(1).get();
    }

    @Transactional
    public Commission createorupdate(double commission){
        Commission commission1 = new Commission(1,commission);
        return commissionRepository.save(commission1);
    }
}
