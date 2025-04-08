package com.example.skillbridge.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.skillbridge.entity.Corso;
import com.example.skillbridge.repository.CorsoRepository;

import lombok.Data;

@Data
@Service
public class CorsoService {

    private final CorsoRepository corsoRepository;

    public List<Corso> getAllCourses() {
        return corsoRepository.findAll();
    }


     //aggiorniamo i vari campi del Corso cercato, ci servirà per il tasto modifica corso
     public Corso updateCorso(Long id, String titolo, String descrizione, String immagine, double prezzo) {
        Corso corso = corsoRepository.findById(id).orElseThrow(() -> new RuntimeException("Corso con id: " + id + " non trovato"));
               
        
        corso.setTitolo(titolo);
        corso.setDescrizione(descrizione);
        corso.setImmagine(immagine);
        corso.setPrezzo(prezzo);
    
        return corsoRepository.saveAndFlush(corso);
    }           

    //aggiunto 26-03
    public void deleteCorso(Long id){
        corsoRepository.deleteById(id);
    }

}
