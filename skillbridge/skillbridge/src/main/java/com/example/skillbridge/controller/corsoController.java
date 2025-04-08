package com.example.skillbridge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.skillbridge.entity.Corso;
import com.example.skillbridge.service.CorsoService;


import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Data
@Controller
@RequestMapping("/public/")
public class corsoController {

    private final CorsoService corsoService;

    @GetMapping("learning")
    public String getMethodName(Model model) {

        // Add collection of courses
        model.addAttribute("corsi", corsoService.getAllCourses());

        return "learning";
    }
}
