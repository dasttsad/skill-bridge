package com.example.skillbridge.entity;

import com.example.skillbridge.entity.GenericEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode (callSuper = true)
public class Commento extends GenericEntity {

    @Column (name = "titolo")
    private String titolo;

    @Column (name = "descrizione")
    private String descrizione;

    @ManyToOne
    @JoinColumn (name = "post_id")
    private Post posts;
}
