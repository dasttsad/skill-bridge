package com.example.skillbridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.skillbridge.entity.Ruolo;

@Repository
public interface RuoloRepository extends JpaRepository<Ruolo, Long> {

}
