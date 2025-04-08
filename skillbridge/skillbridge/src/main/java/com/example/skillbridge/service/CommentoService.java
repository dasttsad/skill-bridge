package com.example.skillbridge.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.skillbridge.entity.Commento;
import com.example.skillbridge.repository.CommentoRepository;

import lombok.Data;

@Data
@Service
public class CommentoService {

    private final CommentoRepository commentoRepository;

    public List<Commento> getAllComments(){
        return commentoRepository.findAll();
    }



    public Commento updateCommento(Long id, String titolo, String descrizione){
        Commento commento = commentoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("inesistente"));

        commento.setTitolo(titolo);
        commento.setDescrizione(descrizione);
    
        return commentoRepository.saveAndFlush(commento);
    }

    public void deleteCommento(Long id){
        commentoRepository.deleteById(id);
    }


}
