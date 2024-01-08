package com.carsale.back.API.Model;

import jakarta.persistence.*;

@Entity
public class StatutVoiture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idStatut")
    private int idPersonne;

}
