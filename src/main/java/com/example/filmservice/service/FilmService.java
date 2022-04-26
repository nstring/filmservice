package com.example.filmservice.service;

import com.example.filmservice.mapper.FilmMapper;
import com.example.filmservice.model.Film;
import com.example.filmservice.model.FilmDTO;
import com.example.filmservice.model.KinopoiskFilm;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;


@Service
public class FilmService {
    private final KinopoiskClient kinopoiskClient;
    private final FilmMapper filmMapper;


    public FilmService(KinopoiskClient kinopoiskClient, FilmMapper filmMapper) {
        this.kinopoiskClient = kinopoiskClient;
        this.filmMapper = filmMapper;
    }

    public List<FilmDTO> findAll() throws URISyntaxException {
        List<FilmDTO> result = new ArrayList<>();
        List<FilmDTO> list = kinopoiskClient.getFilms();
        for(FilmDTO filmDTO : list) {
            result.add(filmMapper.toFilm(filmDTO));
        }
        return result;

    }
}
//        return kinopoiskClient.getFilms().stream()
//                .map(filmMapper::toFilm)
//                .collect(Collectors.toList());
