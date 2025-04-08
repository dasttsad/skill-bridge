package com.example.skillbridge.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Post extends GenericEntity{

    @Column(name="titolo")
    private String titolo;

    @Column(name="descrizione")
    private String descrizione;

    @Column(name="immagine")
    private String immagine;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;

    @OneToMany(mappedBy = "posts")
    private List<Commento> commento;
}