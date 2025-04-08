package com.example.skillbridge.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.skillbridge.entity.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long>{
    
    Utente findByEmail(String email);

    Utente findByUsername(String username);

 
}
