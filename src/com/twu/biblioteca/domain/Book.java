package com.twu.biblioteca.domain;

public class Book {
    public Integer getId() {
        return id;
    }

    private Integer id;
    private String name;
    private String author;
    private String year;

    public Book(Integer id, String name, String author, String year) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return id +" {" +
                 name + '|' +  author + '|' +  year + '}';
    }
}
