package com.example.skillbridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.skillbridge.entity.Recensione;

@Repository
public interface RecensioneRepository extends JpaRepository<Recensione, Long>{

}
