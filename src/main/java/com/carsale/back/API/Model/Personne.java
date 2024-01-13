package com.carsale.back.API.Model;

import jakarta.persistence.*;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPersonne")
    private int idPersonne;

    private String nom;

    private String prenom;
    /*
    * ito atao H na F
    * */
    private char sexe;

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

    /*
    * Atao majuscule daholo
    * */
    @Column(unique = true)
    private String cin;

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public char getSexe() {
        return sexe;
    }

    public void setSexe(char sexe) {
        sexe = Character.toUpperCase(sexe);
        this.sexe = sexe;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) throws  java.text.ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateN = dateFormat.parse(dateNaissance);
        this.dateNaissance = dateN;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMotDePass() {
        return motDePass;
    }

    public void setMotDePass(String motDePass) throws Exception {
        this.motDePass = criptage(motDePass);;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getCin() {
        return cin;
    }

    public Personne(){}
    public Personne(int idPersonne){
        setIdPersonne(idPersonne);
    }


    public Personne(int idPersonne, String nom, String prenom, char sexe, Date dateNaissance,
                    String contact, String mail, String motDePass, String cin) throws Exception{
        setIdPersonne(idPersonne);
        setNom(nom);
        setPrenom(prenom);
        setSexe(sexe);
        setDateNaissance(dateNaissance);
        setContact(contact);
        setMail(mail);
        setMotDePass(motDePass);
        setCin(cin);
    }

    public Personne(String nom, String prenom, char sexe, Date dateNaissance,
                    String contact, String mail, String motDePass, String cin ) throws Exception{
        setNom(nom);
        setPrenom(prenom);
        setSexe(Character.toUpperCase(sexe));
        setDateNaissance(dateNaissance);
        setContact(contact);
        setMail(mail);
        setMotDePass(motDePass);
        setCin(cin);
    }

    public Personne(String nom, String prenom, char sexe, String dateNaissance, String contact,
                    String mail, String motDePass,String cin) throws Exception{
        setNom(nom);
        setPrenom(prenom);
        setSexe(Character.toUpperCase(sexe));
        setDateNaissance(dateNaissance);
        setContact(contact);
        setMail(mail);
        setMotDePass(motDePass);
        setCin(cin);
    }


    public String criptage(String password) throws Exception{
        String sel = "dac6595c04dda81";
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        password = sel + password;
        md.update(password.getBytes());
        byte byteData[] = md.digest();

        //convertir le tableau de bits en une format hexadécimal
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString( (byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}
