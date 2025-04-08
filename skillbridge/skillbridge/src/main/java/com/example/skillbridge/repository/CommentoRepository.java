package com.example.skillbridge.repository;

import org.springframework.stereotype.Repository;

import com.example.skillbridge.entity.Commento;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CommentoRepository extends JpaRepository<Commento,Long>{

}
