package com.carsale.back.API.Service;

import com.carsale.back.API.Model.Admin;
import com.carsale.back.API.Model.Personne;
import com.carsale.back.API.Model.Tokken;
import com.carsale.back.API.Repository.AdminRepository;
import com.carsale.back.API.Repository.TokkenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository admin_rep;

    @Autowired
    private TokkenRepository tokken_rep;

    @Autowired
    private PersonneService personne_service;

    @Autowired
    private TokkenService tokkenService;

    public HashMap<String,Object> ajoutCompteAdmin(Admin a) throws Exception{
        HashMap<String,Object> rep= new HashMap<>();
        Personne p =new Personne();
        String motDePassCrypte = p.criptage(a.getMotDePass());
        p.setNom(a.getNom());
        p.setPrenom(a.getPrenom());
        p.setContact(a.getContact());
        p.setMotDePass(motDePassCrypte);
        p.setMail(a.getMail());

        HashMap<String,Object> hashMap = personne_service.ajoutPersonne(p);

        if(hashMap.get("data")!= null){
            Personne temp = (Personne)  hashMap.get("data");
            p.setIdPersonne(temp.getIdPersonne());
        }if (hashMap.get("tokken") != null){
            rep.put("tokken",hashMap.get("tokken"));
        }
        a.setEtatAdmin(1);
        a.setMotDePass(motDePassCrypte);
        rep.put("data",admin_rep.save(a));
        return rep;
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
