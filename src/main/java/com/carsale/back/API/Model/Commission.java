package com.carsale.back.API.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Commission {
    @Id
    int id_commission;
    double pourcentage;

    public Commission(int i, double commission) {
        setId_commission(i);
        setPourcentage(commission);
    }

    public Commission() {
    }

    public int getId_commission() {
        return id_commission;
    }

    public void setId_commission(int id_commission) {
        this.id_commission = id_commission;
    }

    public double getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(double pourcentage) {
        this.pourcentage = pourcentage;
    }
}
