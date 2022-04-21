package com.example.filmservice.model;

import lombok.Data;

@Data
public class KinopoiskFilm {
    private int kinopoiskId;
    private float ratingImdb;
    private float ratingKinopoisk;
    private String nameRu;
    private int year;
    private String decription;
}
