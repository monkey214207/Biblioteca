package com.twu.biblioteca;


import java.io.PrintStream;

public class BibliotecaApp {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(System.out);
        biblioteca.printWelcomeMessage();
        biblioteca.handleMenu();
    }
}
