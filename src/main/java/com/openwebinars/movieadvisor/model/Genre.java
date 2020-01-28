package com.openwebinars.movieadvisor.model;

import javax.persistence.*;

@Entity
public class Genre {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String genre;
}
