package com.example.skillbridge.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Data;

@Data
@Controller
@RequestMapping("/public/")
public class ChisiamoController {

    @GetMapping("/chisiamo")
    public String getMethodName() {

        return "chisiamo";

    }
}
