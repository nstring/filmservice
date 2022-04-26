package com.example.filmservice.mapper;


import com.example.filmservice.model.Film;
import com.example.filmservice.model.FilmDTO;
import com.example.filmservice.model.KinopoiskFilm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface FilmMapper {
    FilmDTO toFilm(FilmDTO filmDTO);

}
