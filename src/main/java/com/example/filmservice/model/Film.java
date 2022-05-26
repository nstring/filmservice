package com.example.filmservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "films")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "kinopoiskId")
    private Long kinopoiskId;

    @Column(name = "nameRu")
    private String nameRu;

    @Column(name = "year")
    private Integer year;

    @Column(name = "ratingKinopoisk")
    private Integer ratingKinopoisk;

    @Column(name = "ratingImdb")
    private Integer ratingImdb;

    @Column(name = "description")
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(id, film.id) && Objects.equals(kinopoiskId, film.kinopoiskId) && Objects.equals(nameRu, film.nameRu) && Objects.equals(year, film.year) && Objects.equals(ratingKinopoisk, film.ratingKinopoisk) && Objects.equals(ratingImdb, film.ratingImdb) && Objects.equals(description, film.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, kinopoiskId, nameRu, year, ratingKinopoisk, ratingImdb, description);
    }
}
