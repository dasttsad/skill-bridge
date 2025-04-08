package com.example.skillbridge.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.skillbridge.entity.Post;
import com.example.skillbridge.entity.Utente;
import com.example.skillbridge.repository.UtenteRepository;

import lombok.Data;

@Data
@Service
public class UtenteService {

    private final UtenteRepository utenteRepository;

    public List<Utente> getAllUsers(){
        return utenteRepository.findAll();
    }
    
    // public List<Utente> listUtenti() {
    //     // Fetch Utenti with their Posts
    //    return utenteRepository.findAllWithPosts();
       
    // }
     
    public Utente getUserById(Long id) {          //aggiunta
        return utenteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Utente con ID " + id + " non trovato"));
    }
    
    public Utente getUserByEmail(String email){  //aggiunta2
        return utenteRepository.findByEmail(email);
    }
    

    public List<List<Post>> getPostsByUserRole(String ruolo){

        List<List<Post>> ris = new ArrayList<>();

        List<Utente> utenti = utenteRepository.findAll();

        for (var utente : utenti) {

            if(utente.getRuolo().getTipo().equalsIgnoreCase(ruolo)) {
                ris.add(utente.getPosts());
            } 
            
        }

        return ris;
    }

    public Utente updateUtente(
        Long id, String nome, String cognome, 
        String username, String password, 
        String email, LocalDate data_di_Nascita
    ) {
        Utente utente = utenteRepository.findById(id).orElseThrow(() -> new RuntimeException("Corso con id: " + id + " non trovato"));
               
        utente.setId(id);
        utente.setNome(nome);
        utente.setCognome(cognome);
        utente.setUsername(username);
        utente.setPassword(password);
        utente.setEmail(email);
        utente.setData_di_Nascita(data_di_Nascita);
        
    
        return utenteRepository.saveAndFlush(utente);
    }           

    public Utente createUser(String nome, String cognome, LocalDate data_di_nascita, String email, String username, String password)
    {
            Utente utente = new Utente();
            utente.setNome(nome);
            utente.setCognome(cognome);
            utente.setUsername(username);
            utente.setPassword(password);
            utente.setEmail(email);
            utente.setData_di_Nascita(data_di_nascita);

            return utenteRepository.saveAndFlush(utente);
    }

    public void deleteUtente(Long id){
        utenteRepository.deleteById(id);
    }

}
