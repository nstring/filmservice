package com.example.filmservice.repository;

import com.example.filmservice.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

    boolean existsByKinopoiskId(Long kinopoiskId);

}
