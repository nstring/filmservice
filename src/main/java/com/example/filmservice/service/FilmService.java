package com.example.filmservice.service;

import com.example.filmservice.mapper.FilmMapper;
import com.example.filmservice.model.Film;
import com.example.filmservice.model.KinopoiskFilm;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Immutable;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class FilmService {

    private final KinopoiskClient kinopoiskClient;

    public List<Film> findAll() {
        return kinopoiskClient.getFilms().stream()
                .map(this::toFilm)
                .collect(Collectors.toList());

    }
    private Film toFilm(@NonNull KinopoiskFilm kinopoiskFilm) {
        return FilmMapper.INSTANCE.toFilm(kinopoiskFilm);

    }
}