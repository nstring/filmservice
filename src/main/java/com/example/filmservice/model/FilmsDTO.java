package com.example.filmservice.model;

import lombok.Data;

import java.util.List;

@Data
public class FilmsDTO {
    private List<FilmDTO> items;
}
