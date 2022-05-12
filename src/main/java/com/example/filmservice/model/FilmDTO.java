package com.example.filmservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmDTO {
    private String order;
    private String type;
    private int ratingFrom;
    private int ratingTo;
    private int yearFrom;
    private int yearTo;
    private int page;

}
