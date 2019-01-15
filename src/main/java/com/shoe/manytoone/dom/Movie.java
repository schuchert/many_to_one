package com.shoe.manytoone.dom;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue
    Long id;

    @Column
    String title;

    @Column
    String description;

    @ManyToOne(cascade = CascadeType.MERGE)
    Rating rating;
}
