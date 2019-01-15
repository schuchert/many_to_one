package com.shoe.manytoone.dom;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface MovieRepository extends CrudRepository<Movie, Long> {
    Collection<Movie> findByRating(Rating rating);
}
