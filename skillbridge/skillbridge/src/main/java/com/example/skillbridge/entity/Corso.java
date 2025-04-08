package com.example.skillbridge.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Corso extends GenericEntity{

    @Column(name="titolo")
    private String titolo;

    @Column(name="descrizione")
    private String descrizione;

    @Column(name="immagine")
    private String immagine;

    @Column(name="prezzo")
    private double prezzo; 

}
