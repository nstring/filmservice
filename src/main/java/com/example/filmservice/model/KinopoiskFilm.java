package com.example.filmservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KinopoiskFilm {

    private Long id;
    private Integer kinopoiskId;
    private String nameRu;
    private Integer year;
    private Integer ratingKinopoisk;
    private Integer ratingImdb;
    private String description;
}
