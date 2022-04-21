package com.example.filmservice.controller;

import com.example.filmservice.model.Film;
import com.example.filmservice.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/")
public class FilmController {

    @Autowired
    private FilmService filmService;

    @RequestMapping
    public List<Film> getFilm() throws URISyntaxException {
        return filmService.findAll();
    }
}
