package com.example.skillbridge.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.skillbridge.entity.Recensione;
import com.example.skillbridge.entity.Utente;
import com.example.skillbridge.repository.RecensioneRepository;

import lombok.Data;

@Data
@Service
public class RecensioneService {

    private final RecensioneRepository recensioneRepository;

    public List<Recensione> getAllRecensioni(){
        return recensioneRepository.findAll();
    }


    public Recensione updateReview(
        Long id, String testo, 
        int voto, String immagine
    ) {
        Recensione recensione = recensioneRepository.findById(id).orElseThrow(() -> new RuntimeException("Corso con id: " + id + " non trovato"));
               
        recensione.setId(id);
        recensione.setTesto(testo);
        recensione.setVoto(voto);
        recensione.setImmagine(immagine);
        
        return recensioneRepository.saveAndFlush(recensione);
    }           


}
