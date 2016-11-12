package io.github.vdubois.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vdubois on 12/11/16.
 */
@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private Date publicationDate;

    @ManyToMany
    private Set<Author> authors = new HashSet<>();

    @NotNull
    private BigDecimal price;

    @NotNull
    private String editor;

    @NotNull
    private Integer numberOfPages;

    @NotNull
    private String isbn;
}
