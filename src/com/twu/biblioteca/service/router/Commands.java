package com.twu.biblioteca.service.router;

public enum Commands {
    HOME(100,"home"),
    MENU(101,"menu"),
    BOOKLIST(1,"bookList"),
    CHECKOUT(2,"checkout"),
    RETURN(3,"return");

    private int index;
    private String name;

    public int getIndex() {
        return index;
    }

    Commands(int index, String name) {
        this.index = index;
        this.name = name;
    }

}
