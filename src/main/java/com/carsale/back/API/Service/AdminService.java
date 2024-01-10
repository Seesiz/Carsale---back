package com.carsale.back.API.Service;

import com.carsale.back.API.Model.Admin;
import com.carsale.back.API.Model.Personne;
import com.carsale.back.API.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository admin_rep;

    public Admin ajoutCompteAdmin(Admin a){
        a.setEtatAdmin(1);
        a.setMotDePass(a.getMotDePass());
        return admin_rep.save(a);
    }

    public List<Admin> getAdminValid(){
        return admin_rep.findByEtatAdmin(1);
    }

    public Admin modifierCompteAdmin(int idAdmin,Admin ad) throws RuntimeException {
        Admin am = admin_rep.findById(idAdmin).map(
                admin -> {
                    admin.setNom(ad.getNom());
                    admin.setPrenom(ad.getPrenom());
                    admin.setMail(ad.getMail());
                    admin.setContact(ad.getContact());
                    try {
                        admin.setMotDePass(new Personne().criptage(ad.getMotDePass()));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    admin.setArgent(ad.getArgent());
                    return  admin;
                }
        ).orElseThrow(()-> new RuntimeException("impossible de trouver le compte admin avec ID:"+idAdmin));
        return admin_rep.save(am);
    }

    public Admin supprimerCompteAdmin(int idAdmin){
        Admin a = admin_rep.findById(idAdmin).orElseThrow(()-> new RuntimeException("Impossible de trouver l\' admin avec ID:"+idAdmin));
        a.setEtatAdmin(0);
        return  admin_rep.save(a);
    }




}
