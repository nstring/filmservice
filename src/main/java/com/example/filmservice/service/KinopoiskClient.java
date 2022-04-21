package com.example.filmservice.service;

import com.example.filmservice.model.Films;
import com.example.filmservice.model.KinopoiskFilm;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Component
public class KinopoiskClient {

    private final RestTemplate restTemplate = new RestTemplate();
    HttpHeaders httpHeaders = new HttpHeaders();

    public List<KinopoiskFilm> getFilms() {

        String url = "https://kinopoiskapiunofficial.tech/api/v2.2/films?order=RATING&type=ALL&ratingFrom=5&ratingTo=10&yearFrom=2005&yearTo=3000&page=5";

        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        httpHeaders.set("API-KEY", "4b95e124-b726-4b46-bec7-7716cdb9ef45");

        ResponseEntity<Films> response = this.restTemplate.getForEntity(url, Films.class);

        if(response.getStatusCode() == HttpStatus.OK) {
            return Objects.requireNonNull(response.getBody()).getFilmList();
        } else {
            return null;
        }
    }

}
