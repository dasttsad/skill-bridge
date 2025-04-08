package com.example.skillbridge.entity;

import java.time.LocalDate;
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
public class Recensione extends GenericEntity{

    @Column(name="testo")
    private String testo;

    @Column(name="voto")
    private int voto;

    @Column(name="immagine")
    private String immagine;

    @ManyToOne
    @JoinColumn(name="utente_recensisce")
    private Utente utente_recensisce;

    @ManyToOne
    @JoinColumn(name="utente_recensito")
    private Utente utente_recensito;

}
