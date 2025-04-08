package com.example.skillbridge.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.skillbridge.service.UtenteService;

import lombok.Data;

@Data
@Controller
@RequestMapping("/public/")
public class HomeController {

    private final UtenteService utenteService;

     @GetMapping("home")
    public String takeAllUsers(Model model){

        return "index";
    }

}
