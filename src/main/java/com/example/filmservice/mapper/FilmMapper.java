package com.example.filmservice.mapper;


import com.example.filmservice.model.Film;
import com.example.filmservice.model.KinopoiskFilm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(uses = {KinopoiskFilm.class})
public interface FilmMapper {
    @Mapping(target = "id", ignore = true)
    Film toFilm(KinopoiskFilm kinopoiskFilm);
    FilmMapper INSTANCE = Mappers.getMapper(FilmMapper.class);
}
