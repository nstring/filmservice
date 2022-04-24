package com.example.filmservice.service;

import com.example.filmservice.model.Films;
import com.example.filmservice.model.KinopoiskFilm;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Component
public class KinopoiskClient {

    HttpClient httpClient = HttpClientBuilder.create().build();
    ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);

    private final RestTemplate restTemplate = new RestTemplate(requestFactory);
    HttpHeaders httpHeaders = new HttpHeaders();

    public List<KinopoiskFilm> getFilms() throws URISyntaxException {

        String url = "https://kinopoiskapiunofficial.tech/api/v2.2/films?type=FILM&ratingFrom=5&ratingTo=10&yearFrom=2002&yearTo=2021&page=1";


        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        httpHeaders.set("X-API-KEY", "4b95e124-b726-4b46-bec7-7716cdb9ef45");

        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<Films> response = restTemplate.exchange(new URI(url), HttpMethod.GET, httpEntity, Films.class);

        if(response.getStatusCode() == HttpStatus.OK) {
            return Objects.requireNonNull(response.getBody()).getFilmList();
        } else {
            return null;
        }
    }

}
