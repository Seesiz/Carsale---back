package com.carsale.back.API.Service;

import com.carsale.back.API.Model.Admin;
import com.carsale.back.API.Model.Personne;
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
        p.setNom(a.getNom());
        p.setPrenom(a.getPrenom());
        p.setContact(a.getContact());
        p.setMail(a.getMail());
        p.setMotDePass(a.getMotDePass());
        p.setCin(null);
        p.setDateNaissance(a.getDateNaissance());
        p.setSexe('N');

        HashMap<String,Object> hashMap = personne_service.ajoutPersonne(p);

        if (hashMap.get("tokken") != null){
            rep.put("tokken",hashMap.get("tokken"));
        }
        a.setEtatAdmin(1);
        rep.put("data",admin_rep.save(a));
        return rep;
    }

    public List<Admin> getAdminValid(){
        return admin_rep.findByEtatAdmin(1);
    }

    public HashMap<String, Object> login(String mail,String motDePass){
        HashMap<String,Object> rep =new HashMap<>();
        try {
            String motDePassCripte= new Personne().criptage(motDePass);
            HashMap<String,Object> personne = personne_service.login(mail,motDePass);

            Admin a = admin_rep.findByMail(mail);
            if(a==null){
                rep.put("message","Le compte est introuvable");
                return rep;
            }
            if(!a.getMotDePass().equals(motDePassCripte)){
                rep.put("message","Mot pass invalide");
                return rep;
            }
            rep.put("data",a);
            return rep;
        }catch (Exception e){
            rep.put("message",e.getMessage());
            return rep;
        }
    }

    public Admin modifierCompteAdmin(int idAdmin,Admin ad) throws RuntimeException {
        Admin am = admin_rep.findById(idAdmin).map(
                admin -> {
                    admin.setNom(ad.getNom());
                    admin.setPrenom(ad.getPrenom());
                    admin.setMail(ad.getMail());
                    admin.setContact(ad.getContact());
                    try {
                        admin.setMotDePass(ad.getMotDePass());
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
