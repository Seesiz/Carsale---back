package com.carsale.back.API.Repository;

import com.carsale.back.API.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {
    List<Admin> findByEtatAdmin(int EtatAdmin);
}
