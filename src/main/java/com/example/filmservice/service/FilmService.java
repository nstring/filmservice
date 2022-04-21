package com.example.filmservice.service;

import com.example.filmservice.model.Film;
import com.example.filmservice.model.KinopoiskFilm;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmService {

    @Autowired
    private KinopoiskClient kinopoiskClient;

    public List<Film> findAll() throws URISyntaxException {
        return kinopoiskClient.getFilms().stream()
                .map(this::toFilm)
                .collect(Collectors.toList());

    }
    private Film toFilm(@NonNull KinopoiskFilm kinopoiskFilm) {
        return new Film(1L,
                kinopoiskFilm.getKinopoiskId(),
                kinopoiskFilm.getRatingImdb(),
                kinopoiskFilm.getRatingKinopoisk(),
                kinopoiskFilm.getNameRu(),
                kinopoiskFilm.getYear(),
                kinopoiskFilm.getDecription());

    }
}
