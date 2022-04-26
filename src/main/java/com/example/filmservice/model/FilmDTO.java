package com.example.filmservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmDTO {
    private String type;
    private int ratingFrom;
    private int ratingTo;
    private int yearFrom;
    private int yearTo;
    private int page;

}
