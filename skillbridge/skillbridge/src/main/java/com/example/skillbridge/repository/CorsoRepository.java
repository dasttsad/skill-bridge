package com.example.skillbridge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.skillbridge.entity.Corso;

@Repository
public interface CorsoRepository extends JpaRepository<Corso, Long> {
    
}
