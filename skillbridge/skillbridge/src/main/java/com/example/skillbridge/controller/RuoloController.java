package com.example.skillbridge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.skillbridge.service.RuoloService;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Data
@Controller
public class RuoloController {

    private final RuoloService ruoloService;

    @GetMapping("/ruolo")
    public String getMethodName(Model model) {

        model.addAttribute("ruoli", ruoloService.getAllRoles());

        return "ruoli";
    }
    

}
