package com.twu.biblioteca.domain;

public class Book {
    public Integer getId() {
        return id;
    }

    private Integer id;
    private String name;
    private String author;
    private String year;

    public Book() {}

    public Book(Integer id, String name, String author, String year) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return id +" {" +
                 name + '|' +  author + '|' +  year + '}';
    }
}
