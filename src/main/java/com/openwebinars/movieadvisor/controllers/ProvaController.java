package com.openwebinars.movieadvisor.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;

@Controller
public class ProvaController {
    @GetMapping("/")
    public String prova(Locale locale, Model model){
        return "prova";
    }
}
