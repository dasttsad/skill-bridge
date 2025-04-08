package com.example.skillbridge.controller;

import com.example.skillbridge.service.RecensioneService;

import lombok.Data;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Data
@Controller
public class RecensioneController {
    private final RecensioneService recensioneService;

    
    @GetMapping("/recensioni")
    public String getMethodName(Model model){

        //add all users 
        model.addAttribute("recensioni", recensioneService.getAllRecensioni());
        
        return "recensioni";
    }

    @PostMapping("/modifica/recensioniConUtente")
    public String seeRewievs(@RequestParam Long id, @RequestParam String testo, @RequestParam int voto, @RequestParam String immagine) {

        recensioneService.updateReview(id, testo, voto, immagine);
        
        return "redirect:/UserReviews";
    }

    @PostMapping("/recensione/elimina")
    public String eliminaUtente(@RequestParam Long id) {

        recensioneService.getRecensioneRepository().delete(recensioneService.getRecensioneRepository().getReferenceById(id));

        return "redirect:/UserReviews"; 
    }

}
