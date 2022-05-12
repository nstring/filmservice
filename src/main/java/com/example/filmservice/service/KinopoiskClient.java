package com.example.filmservice.service;

import com.example.filmservice.model.FilmDTO;

import com.example.filmservice.model.Films;
import com.example.filmservice.model.KinopoiskFilm;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class KinopoiskClient {

    private final RestTemplate restTemplate;

    public KinopoiskClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<KinopoiskFilm> getFilms(FilmDTO filter) {

        HttpHeaders httpHeaders = new HttpHeaders();


        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        httpHeaders.set("X-API-KEY", "4b95e124-b726-4b46-bec7-7716cdb9ef45");

        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<Films> response = restTemplate.exchange(generateUrl(filter), HttpMethod.GET, httpEntity, Films.class);

        if(response.getStatusCode() == HttpStatus.OK && response.getBody() != null && response.getBody().getItems() != null) {
            return response.getBody().getItems();
        } else {
            return new ArrayList<>();
        }
    }

    public String generateUrl(FilmDTO filter) {
        String URL = "https://kinopoiskapiunofficial.tech/api/v2.2/films";
        final String fullUrl = String.join("", URL);
        final Optional<FilmDTO> optionalFilter = Optional.ofNullable(filter);
        List<String> params = new ArrayList<>();
        optionalFilter.map(FilmDTO::getType)
                .ifPresent(type -> params.add(String.join("=", "type", type)));

        optionalFilter.map(FilmDTO::getOrder)
                .ifPresent(order -> params.add(String.join("=", "order", order)));

        optionalFilter.map(FilmDTO::getRatingFrom)
                .ifPresent(ratingFrom -> params.add(String.join("=", "ratingFrom", ratingFrom.toString())));

        optionalFilter.map(FilmDTO::getRatingTo)
                .ifPresent(ratingTo -> params.add(String.join("=", "ratingTo", ratingTo.toString())));

        optionalFilter.map(FilmDTO::getYearFrom)
                .ifPresent(yearFrom -> params.add(String.join("=", "yearFrom", yearFrom.toString())));

        optionalFilter.map(FilmDTO::getYearTo)
                .ifPresent(yearTo -> params.add(String.join("=", "yearTo", yearTo.toString())));

        optionalFilter.map(FilmDTO::getPage)
                .ifPresent(page -> params.add(String.join("=", "page", page.toString())));

        return fullUrl;
    }
}
