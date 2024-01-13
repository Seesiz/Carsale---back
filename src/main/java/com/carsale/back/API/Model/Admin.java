package com.carsale.back.API.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Admin{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCategorie")
    private int idAdmin;

    private String nom;

    private String prenom;

    @Column(name = "dateNaissance" , columnDefinition = "date")
    private Date dateNaissance;

    private String contact;

    /*
     * Tsimaintsy mail tena misy
     * Tsimaitsy misy amin'ny tena izy
     * */
    @Column(unique = true)
    private String mail;

    @Column(name = "motDePass",columnDefinition = "Text")
    private String motDePass;

    @Column(columnDefinition = "numeric(15,2)")
    private double argent;

    /*
    * Etat = 1 : admin actuel
    * Etat = 0 : ancien admin
    * */
    @ColumnDefault("1")
    private int etatAdmin;

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    public void setArgent(double argent) {
        this.argent = argent;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) throws  java.text.ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateN = dateFormat.parse(dateNaissance);
        this.dateNaissance = dateN;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setMotDePass(String motDePass) {
        this.motDePass = motDePass;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public double getArgent() {
        return argent;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public String getContact() {
        return contact;
    }

    public String getMail() {
        return mail;
    }

    public String getMotDePass() {
        return motDePass;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setEtatAdmin(int etatAdmin) {
        this.etatAdmin = etatAdmin;
    }

    public int getEtatAdmin() {
        return etatAdmin;
    }

    public Admin(){}

    public Admin(int idAdmin, String nom, String prenom, Date dateNaissance,
                 String contact, String mail, String motDePass, double argent,int etatAdmin) {
        setIdAdmin(idAdmin);
        setNom(nom);
        setPrenom(prenom);
        setDateNaissance(dateNaissance);
        setContact(contact);
        setMail(mail);
        setMotDePass(motDePass);
        setArgent(argent);
        setEtatAdmin(etatAdmin);
    }

    public Admin(String nom, String prenom, Date dateNaissance, String contact,
                 String mail, String motDePass, double argent,int etatAdmin) {
        setNom(nom);
        setPrenom(prenom);
        setDateNaissance(dateNaissance);
        setContact(contact);
        setMail(mail);
        setMotDePass(motDePass);
        setArgent(argent);
        setEtatAdmin(etatAdmin);
    }

    public Admin(String nom, String prenom, String dateNaissance, String contact,
                 String mail, String motDePass, double argent,int etatAdmin) throws  java.text.ParseException {
        setNom(nom);
        setPrenom(prenom);
        setDateNaissance(dateNaissance);
        setContact(contact);
        setMail(mail);
        setMotDePass(motDePass);
        setArgent(argent);
        setEtatAdmin(etatAdmin);
    }
}
