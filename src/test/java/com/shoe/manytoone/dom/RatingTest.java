package com.shoe.manytoone.dom;

import com.shoe.manytoone.TestApplicationContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RatingTest {
    @Test
    void entitiesThere() {
        RatingRepository ratingRepository = TestApplicationContext.getBean(RatingRepository.class);
        final Iterable<Rating> all = ratingRepository.findAll();
        assertEquals(3l, all.spliterator().getExactSizeIfKnown());
    }
}
