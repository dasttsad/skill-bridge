package com.example.skillbridge.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Ruolo extends GenericEntity{

    @Column(name="tipo")
    private String tipo;

    @OneToMany(mappedBy = "ruolo")
    private List<Utente> utenti;

}
