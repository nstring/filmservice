package com.example.filmservice.service;

import com.example.filmservice.model.FilmDTO;
import com.example.filmservice.model.Films;
import com.example.filmservice.model.FilmsDTO;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Component
public class KinopoiskClient {

    private final RestTemplate restTemplate;

    public KinopoiskClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public List<FilmDTO> getFilms() throws URISyntaxException {

        HttpHeaders httpHeaders = new HttpHeaders();
        String url = "https://kinopoiskapiunofficial.tech/api/v2.2/films?type=FILM&ratingFrom=5&ratingTo=10&yearFrom=2002&yearTo=2021&page=1";



        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        httpHeaders.set("X-API-KEY", "4b95e124-b726-4b46-bec7-7716cdb9ef45");

        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<FilmsDTO> response = this.restTemplate.exchange(new URI(url), HttpMethod.GET, httpEntity, FilmsDTO.class);

        if(response.getStatusCode() == HttpStatus.OK && response.getBody() != null && response.getBody().getItems() != null) {
            return response.getBody().getItems();
        } else {
            return new ArrayList<>();
        }
    }

}
