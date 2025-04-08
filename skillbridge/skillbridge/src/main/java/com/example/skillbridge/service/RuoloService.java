package com.example.skillbridge.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.skillbridge.entity.Corso;
import com.example.skillbridge.entity.Ruolo;
import com.example.skillbridge.repository.RuoloRepository;

import lombok.Data;

@Data
@Service
public class RuoloService {

    private final RuoloRepository ruoloRepository;

    public List<Ruolo> getAllRoles() {
        return ruoloRepository.findAll();
    }

}
