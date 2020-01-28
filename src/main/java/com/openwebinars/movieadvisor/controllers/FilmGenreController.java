package com.openwebinars.movieadvisor.controllers;

import com.openwebinars.movieadvisor.model.Film;
import com.openwebinars.movieadvisor.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
public class FilmGenreController {

    @Autowired
    private FilmService filmservice;

    @GetMapping("/categoria/{genre}")
    public String filmByGenre(@PathVariable("genre") String genre, Model model){

        filmservice.restart();
        List<Film> films = (List<Film>) filmservice.findByAnyGenre(genre);
        model.addAttribute("films", films);
        model.addAttribute("genre",genre);
        return "filmsByGenre";
    }


}
