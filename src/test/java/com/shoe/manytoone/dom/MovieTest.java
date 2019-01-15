package com.shoe.manytoone.dom;

import com.shoe.manytoone.TestApplicationContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTest {
    private MovieRepository movieRepository;

    @BeforeEach
    public void init() {
        movieRepository = TestApplicationContext.getBean(MovieRepository.class);
        clear();
    }

    @AfterEach
    public void clear() {
        movieRepository.deleteAll();
    }

    @Test
    void createMovie() {
        final Movie movie = Movie.builder().title("Hospital Bot").description("Zany AI takes over").rating(Rating.R).build();
        movieRepository.save(movie);
        movieRepository.findAll();
        assertEquals(1l, movieRepository.findAll().spliterator().getExactSizeIfKnown());
    }

    @Test
    void findByRating() {
        final List<Movie> movies = Arrays.asList(
                Movie.builder().title("Hospital Bot").description("Zany AI takes over").rating(Rating.R).build(),
                Movie.builder().title("Hospital Bot").description("Zany AI takes over").rating(Rating.PG13).build(),
                Movie.builder().title("Hospital Bot").description("Zany AI takes over").rating(Rating.PG13).build(),
                Movie.builder().title("Hospital Bot").description("Zany AI takes over").rating(Rating.R).build(),
                Movie.builder().title("Hospital Bot").description("Zany AI takes over").rating(Rating.R).build(),
                Movie.builder().title("Hospital Bot").description("Zany AI takes over").rating(Rating.R).build(),
                Movie.builder().title("Hospital Bot").description("Zany AI takes over").rating(Rating.R).build()
        );
        movieRepository.saveAll(movies);

        final Collection<Movie> pg13 = movieRepository.findByRating(Rating.PG13);
        assertEquals(2l, pg13.size());

        final Collection<Movie> r = movieRepository.findByRating(Rating.R);
        assertEquals(5l, r.size());
    }
}
