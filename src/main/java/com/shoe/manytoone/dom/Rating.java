package com.shoe.manytoone.dom;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    public static final Rating G = new Rating(1, "G", "brett", LocalDateTime.now());
    public static final Rating PG13 = new Rating(2, "PG13", "brett", LocalDateTime.now());
    public static final Rating R = new Rating(3, "R", "brett", LocalDateTime.now());

    @Id
    @Column(name = "ID")
    Integer id;

    @Column(name="NAME",length = 32)
    String name;

    @Column(name="CREATED_BY")
    String createdBy;

    @Column(name="CREATED_ON")
    LocalDateTime createdOn;
}
