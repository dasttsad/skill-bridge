package com.example.skillbridge.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.skillbridge.service.UtenteService;


@Data
@Controller
public class LogController {

    private final UtenteService utenteService;

    @GetMapping("/login")
    public String getMethodName() {
        return "login2";
    }

    @GetMapping("/register")
    public String loadRegisterPage() {
        return "register";
    }
    

    @PostMapping("/register")
    public String register(@RequestParam String nome, @RequestParam String cognome, @RequestParam String username, @RequestParam LocalDate data_di_nascita, @RequestParam String email, @RequestParam String password) {

        utenteService.createUser(nome, cognome, data_di_nascita, email, username, password);
        return "login2";
    }
    
    

}
