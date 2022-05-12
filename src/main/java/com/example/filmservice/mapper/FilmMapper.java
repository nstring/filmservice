package com.example.filmservice.mapper;


import com.example.filmservice.model.Film;
import com.example.filmservice.model.KinopoiskFilm;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
@Component
public interface FilmMapper {
    Film toFilm(KinopoiskFilm kinopoiskFilm);

}
