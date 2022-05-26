package com.example.filmservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FromDbFilter {

    private List<Long> kinopoiskId;
    private List<String> filmNames;
    private List<Integer> ratingKinopoisk;
    private List<Integer> ratingImdb;
    private YearFromTo yearFromTo;
    private RatingFromTo ratingFromTo;

}

