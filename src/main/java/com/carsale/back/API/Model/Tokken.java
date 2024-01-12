package com.carsale.back.API.Model;

import jakarta.persistence.*;

import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
@Entity
public class Tokken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idTokken")
    private int idTokken;

    private String valeurtokken;

    @ManyToOne
    @JoinColumn(name = "idPersonne", referencedColumnName = "idPersonne")
    private Personne personne;
    private Date dateTimeDebut;
    private Date dateTimeFin;

    public void setPersonne(Personne idPersonne) {
        this.personne = idPersonne;
    }

    public void setValeurtokken(String valeurtokken) {
        this.valeurtokken = valeurtokken;
    }

    public void setDateTimeDebut(Date dateTimeDebut) {
        this.dateTimeDebut = dateTimeDebut;
    }

    public void setIdTokken(int idTokken) {
        this.idTokken = idTokken;
    }

    public void setDateTimeFin(Date dateTimeFin) {
        this.dateTimeFin = dateTimeFin;
    }

    public Date getDateTimeDebut() {
        return dateTimeDebut;
    }

    public Date getDateTimeFin() {
        return dateTimeFin;
    }

    public int getIdTokken() {
        return idTokken;
    }

    public String getValeurtokken() {
        return valeurtokken;
    }

    public Personne getPersonne() {
        return personne;
    }
    public Tokken(){}
    public Tokken(Personne personne,Date dateTimeDebut) throws Exception {
        setPersonne(personne);
        setDateTimeDebut(dateTimeDebut);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateTimeDebut);
        calendar.add(Calendar.DATE, 1);
        Date d = calendar.getTime();
        setDateTimeFin(d);
        setValeurtokken(genererTokken(dateTimeDebut));
    }



    public String genererTokken(Date dateTimeDebut) throws Exception{
        String sel = "dac6595c04dda81";
        String date = dateTimeDebut.toString();
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        date = sel + date;
        md.update(date.getBytes());
        byte byteData[] = md.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString( (byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}
