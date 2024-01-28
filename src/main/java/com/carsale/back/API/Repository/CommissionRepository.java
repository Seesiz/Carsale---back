package com.carsale.back.API.Repository;

import com.carsale.back.API.Model.Commission;
import org.springframework.data.repository.CrudRepository;

public interface CommissionRepository extends CrudRepository<Commission,Integer> {
}
