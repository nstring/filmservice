package com.example.filmservice.controller;

import com.example.filmservice.model.Film;
import com.example.filmservice.model.FilmDTO;
import com.example.filmservice.model.FromDbFilter;
import com.example.filmservice.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class FilmController {

    private final FilmService filmService;

    @GetMapping("/cinema")
    public List<Film> getFilm(FilmDTO filter) {
        return filmService.findAll(filter);
    }

    @PostMapping("/cinema")
    public List<Film> saveFilm(FilmDTO filter) {
//
//        List<Film> filmList = filmService.findAll(filter);
//        if (!repository.existsById(film.getKinopoiskId())) {
//            return repository.save(filmList);
//        }
        return filmService.addFilm(filter);
    }



    @GetMapping("/fromdb")
    public List<Film> getFilmsFromDb(FromDbFilter filter) {
        return filmService.getFilmsFromDb(filter);
    }
}
