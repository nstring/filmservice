package com.example.filmservice.controller;

import com.example.filmservice.model.Film;
import com.example.filmservice.model.FilmDTO;
import com.example.filmservice.service.FilmService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class FilmController {

    private final FilmService filmService;

    @GetMapping("/cinema")
    public List<FilmDTO> getFilm() throws URISyntaxException {
        return filmService.findAll();
    }


    @RequestMapping("/getCinema")
    public List<Object> getAllCinema(@RequestParam (value = "films") String filmDto) throws JsonProcessingException {
        final FilmDTO film = new ObjectMapper().readValue(filmDto, FilmDTO.class);
        return Arrays.asList(
                film.getType(),
                film.getRatingFrom(),
                film.getRatingTo(),
                film.getYearFrom(),
                film.getYearTo(),
                film.getPage());
    }

}
