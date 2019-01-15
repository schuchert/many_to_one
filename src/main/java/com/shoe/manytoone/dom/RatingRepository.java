package com.shoe.manytoone.dom;

import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends CrudRepository<Rating, Integer> {
    public Rating findByNameIgnoreCase(String name);
}
