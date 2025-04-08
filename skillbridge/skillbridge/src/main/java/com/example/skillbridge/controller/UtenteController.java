package com.example.skillbridge.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.skillbridge.entity.Utente;
import com.example.skillbridge.repository.UtenteRepository;
import com.example.skillbridge.service.UtenteService;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Data
@Controller
public class UtenteController {

    private final UtenteService utenteService;

    @GetMapping("/utenti")
    public String takeAllUsers(Model model){


        //add all users 
        model.addAttribute("utenti", utenteService.getAllUsers());
        
        return "index";
    }

     @GetMapping("/profilo/{id}")   //inserire nell'url il numero ID per ora
    public String getUserProfileById(@PathVariable Long id, Model model) {
        try {
            Utente utente = utenteService.getUserById(id);
            model.addAttribute("utente", utente);
            return "profiloUtente";
        } catch (NoSuchElementException e) {
            model.addAttribute("errore", "Utente non trovato!");
            return "error";
        }
    }


    @GetMapping("/email/{email}")
    public String getUserProfilebyEmail(@PathVariable String email, Model model) {
        try {
            Utente utente = utenteService.getUserByEmail(email);
            model.addAttribute("utente", utente);
            return "profiloUtente";
        } catch (NoSuchElementException e) {
            model.addAttribute("errore", "Utente non trovato!");
            return "error";
        }
    }

    @GetMapping("/post-per-ruolo")
    public String getPostsByRole(Model model) {
        
        model.addAttribute("posts", utenteService.getPostsByUserRole("freelance"));

        return "stampaPost";
    }

    @GetMapping("/UserReviews")
    public String seeRewievs(Model model) {

        model.addAttribute("utenti", utenteService.getAllUsers());
        
        return "reviewsUsers";
    }
    

    @PostMapping("/modifica/utente")
    public String changeUser(@RequestParam Long id,@RequestParam String nome,@RequestParam String cognome, 
    @RequestParam String username,@RequestParam String password, 
    @RequestParam String email,@RequestParam LocalDate data_di_Nascita) 
    {
        utenteService.updateUtente(
         id,  nome,  cognome, 
         username,  password, 
         email, data_di_Nascita);

        return "redirect:/utenti";
    }

     @PostMapping("utenti/elimina")
    public String eliminaUtente(@RequestParam Long id) {

        utenteService.getUtenteRepository().delete(utenteService.getUtenteRepository().getReferenceById(id));

        return "redirect:/utenti"; 
    }
}
