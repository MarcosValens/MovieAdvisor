package com.openwebinars.movieadvisor.controllers;

import com.openwebinars.movieadvisor.model.Film;
import com.openwebinars.movieadvisor.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@Transactional
public class FilmFormController {

    @Autowired
    private FilmService filmservice;

    @GetMapping("/addFilm")
    public String addFilm(Model model){

        return "filmForm";
    }
    @PostMapping("/savefilm")
    public RedirectView save(@RequestParam("titol")String titol, @RequestParam("any") String any){
        Film film = new Film();
        film.setTitle(titol);
        film.setYear(any);
        filmservice.save(film);
        return new RedirectView("./genres");

    }

}
