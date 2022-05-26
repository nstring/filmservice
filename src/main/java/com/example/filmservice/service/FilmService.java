package com.example.filmservice.service;

import com.example.filmservice.mapper.FilmMapper;
import com.example.filmservice.model.Film;
import com.example.filmservice.model.FilmDTO;
import com.example.filmservice.model.FromDbFilter;
import com.example.filmservice.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class FilmService {

    private final KinopoiskClient kinopoiskClient;
    private final FilmMapper filmMapper;
    private final FilmRepository repository;

    @PersistenceContext
    private final EntityManager em;


    public List<Film> findAll(FilmDTO filter) {
        return kinopoiskClient.getFilms(filter).stream()
                    .map(filmMapper::toFilm)
                    .collect(Collectors.toList());
    }

    public List<Film> getFilmsFromDb(FromDbFilter filter) {
        if(filter == null) {
            return null;
        }
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Film> cq = cb.createQuery(Film.class);

        Root<Film> films = cq.from(Film.class);

        Path<Integer> kinopoiskId = films.get("kinopoiskId");
        Path<String> nameRu = films.get("nameRu");
        Path<Integer> year = films.get("year");
        Path<Integer> ratingKinopoisk = films.get("ratingKinopoisk");
        Path<Integer> ratingImdb = films.get("ratingImdb");

        List<Predicate> predicateList = new ArrayList<>();

        if(filter.getKinopoiskId() != null) {
            predicateList.add(cb.in(kinopoiskId));
        }
        if(filter.getFilmNames() != null) {
            predicateList.add(cb.in(nameRu));
        }

        if (filter.getYearFromTo() != null) {
            predicateList.add(cb.in(year));
            }

        if (filter.getRatingKinopoisk() != null) {
            predicateList.add(cb.in(ratingKinopoisk));
            }
        if (filter.getRatingImdb() != null) {
            predicateList.add(cb.in(ratingImdb));
        }

        cq.where(predicateList.toArray(new Predicate[0]));
        TypedQuery<Film> query = em.createQuery(cq);

        return query.getResultList();
        }

    public List<Film> addFilm(FilmDTO filter) {
        return kinopoiskClient.getFilms(filter).stream()
                .map(filmMapper::toFilm)
                .peek(this::saveFromDb)
                .collect(Collectors.toList());
    }

    public void saveFromDb(Film film) {
        if (!repository.existsByKinopoiskId(film.getKinopoiskId())) {
            repository.save(film);
        }
    }

}

