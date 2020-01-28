package com.openwebinars.movieadvisor.controllers;

import com.openwebinars.movieadvisor.model.Film;
import com.openwebinars.movieadvisor.model.Genre;
import com.openwebinars.movieadvisor.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Locale;

@Controller
public class GenreController {
    @Autowired
    private FilmService filmservice;

    @GetMapping("/genres")
    public String prova(Locale locale, Model model){
        //List<Genre> genres = (List<Genre>) filmservice.findAllGenres();
        List<Film> films = (List<Film>) filmservice.findAll();
        model.addAttribute("films", films);
        return "genres";
    }
}
