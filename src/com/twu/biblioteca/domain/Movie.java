package com.twu.biblioteca.domain;

public class Movie {
    private Integer id;
    private String name;
    private String year;
    private String director;
    private Integer rating;

    public Integer getId() {
        return id;
    }

    public Movie(Integer id, String name, String year, String director, Integer rating) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return id +" {" +
                name + '|' +  year + '|' +  director + '|'  + rating +'}';
    }
}
