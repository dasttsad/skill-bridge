package com.example.skillbridge.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.skillbridge.entity.Commento;
import com.example.skillbridge.service.CommentoService;
import com.example.skillbridge.service.CorsoService;
import com.example.skillbridge.service.PostService;
import com.example.skillbridge.service.UtenteService;

import lombok.Data;

@Data
@Controller
@RequestMapping("/admin/")
public class AdminController {

    private final CorsoService corsoService;
    private final PostService postService;
    private final CommentoService commentoService;
    private final UtenteService utenteService;

    @GetMapping("utenti")
    public String getAllUsers(Model model){
        model.addAttribute("utenti", utenteService.getAllUsers());
        return "/admin/utenti";
    }

    @GetMapping("elimina-utente")
    public String eliminaUtente(@RequestParam Long id){
        if(id != 0){
            utenteService.deleteUtente(id);
        }
        return "redirect:/admin/utenti";
    }

    @PostMapping("utente/modifica")
    public String modificaUtente(
        @RequestParam Long Id, 
        @RequestParam String nome, 
        @RequestParam String cognome, 
        @RequestParam String username,
        @RequestParam String password,
         @RequestParam String email,
         @RequestParam LocalDate data_di_Nascita){
        utenteService.updateUtente(Id, nome, cognome, username, password, email, data_di_Nascita);
        return  "redirect:/admin/utenti";
    }

     @GetMapping("corsi")
    public String AllCourses(Model model) {

        // Add collection of courses
        model.addAttribute("corsi", corsoService.getAllCourses());

        return "/admin/corsi";
    }

    @GetMapping("elimina-corso")
    public String eliminaCorso(@RequestParam(defaultValue = "0L")Long id) {
        if(id !=0){
            corsoService.deleteCorso(id);
            }
        return "redirect:/admin/corsi";
    }

    @PostMapping("corso/modifica")
    public String modificaCorso(@RequestParam Long Id, @RequestParam String titolo, @RequestParam String descrizione, @RequestParam String immagine, @RequestParam double prezzo){
        corsoService.updateCorso(Id, titolo, descrizione, immagine, prezzo);
        return  "redirect:/admin/corsi";
    }


    @GetMapping("posts")
    public String allPosts(Model model) {

        model.addAttribute("posts", postService.getAllPosts());
        return "/admin/post";
    }

     //AGGIUNTA 26-03
    @PostMapping("post/modifica")
    public String modificaPost(@RequestParam Long Id, String titolo, @RequestParam String descrizione, @RequestParam String immagine, @RequestParam Long utente_id){
        postService.updatePost(Id, titolo, descrizione, immagine, utente_id);
        return  "redirect:/admin/posts";
    }

    //aggiunta 26-03
    @GetMapping("elimina-post")
    public String eliminaPost(@RequestParam(defaultValue = "0L") Long id){
        if (id != 0) {
            postService.deletePost(id);
        }
        return "redirect:/admin/posts";
    }


      @GetMapping("commento")
    public String getCommenti(Model model) {
        
        model.addAttribute("commenti", commentoService.getAllComments());

        return "/admin/commento";
    }
    

    //modifica di un commento
    @PostMapping("/modifica-commento")
    public String modificaCommento(@RequestParam Long id, @RequestParam String titolo, @RequestParam String descrizione) {
        
        //oggetto di tipo Commento
        Commento commento = commentoService.updateCommento(id, titolo, descrizione);
        
        return "redirect:/admin/commento";
    }

    @GetMapping("/elimina-commento")
    public String eliminaCommento(@RequestParam(defaultValue = "0L")Long id) {
        if(id !=0){
            commentoService.deleteCommento(id);
            }
        return "redirect:/admin/commento";
    }

}
