package com.example.skillbridge.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Utente extends GenericEntity {

    //id già autoincremented e ripreso da GenericEntity? chiedere

    @Column(name="nome")
    private String nome;

    @Column(name="cognome")
    private String cognome;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password; 

    @Column(name="email")
    private String email;

    @Column(name="data_di_nascita" )
    private LocalDate data_di_Nascita;

    
    @ManyToOne
    @JoinColumn(name = "ruolo_id", referencedColumnName = "id")
    private Ruolo ruolo;


    @OneToMany(mappedBy = "utente", fetch = FetchType.EAGER)
    private List<Post> posts;
    

    //private List<Recensione> recensioni; va inserita qui?
    @OneToMany(mappedBy="utente_recensisce")
    private List<Recensione> recensioniSvolte;

    @OneToMany(mappedBy = "utente_recensito")
    private List<Recensione> recensioniSubite;
}











    

