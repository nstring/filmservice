package com.example.filmservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int kinopoiskId;
    private float ratingImdb;
    private float ratingKinopoisk;
    private String nameRu;
    private int year;
    private String decription;
}
