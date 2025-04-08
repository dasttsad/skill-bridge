package com.example.skillbridge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.skillbridge.entity.Commento;
import com.example.skillbridge.service.CommentoService;


@Data
@Controller
public class CommentoController {

    private final CommentoService commentoService;

    @GetMapping("/commenti")
    public String getCommenti(Model model) {
        
        model.addAttribute("commenti", commentoService.getAllComments());

        return "commento";
    }
    

    //modifica di un commento
    @PostMapping("/modifica-commento")
    public String modificaCommento(@RequestParam Long id, @RequestParam String titolo, @RequestParam String descrizione) {
        
        //oggetto di tipo Commento
        Commento commento = commentoService.updateCommento(id, titolo, descrizione);
        
        return "redirect:/commenti";
    }

    @GetMapping("/elimina-commento")
    public String eliminaCommento(@RequestParam(defaultValue = "0L")Long id) {
        if(id !=0){
            commentoService.deleteCommento(id);
            }
        return "redirect:/commenti";
    }




}
