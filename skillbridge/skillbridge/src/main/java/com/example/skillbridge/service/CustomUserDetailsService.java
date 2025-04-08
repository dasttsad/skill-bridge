package com.example.skillbridge.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.skillbridge.entity.Utente;
import com.example.skillbridge.repository.UtenteRepository;

import lombok.Data;

@Data
@Service
public class CustomUserDetailsService implements UserDetailsService 
{
    private final UtenteRepository utenteRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        Utente utente = utenteRepository.findByUsername(email);

        return org.springframework.security.core.userdetails.User
        .withUsername(utente.getUsername())
        .password("{noop}" + utente.getPassword())
        .roles(utente.getRuolo().getTipo())
        .build();
    }
}
