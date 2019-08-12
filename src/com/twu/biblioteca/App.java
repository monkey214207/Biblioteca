package com.twu.biblioteca;

import com.twu.biblioteca.controller.BibliotecaController;

public class App {
    public static void main(String[] args) {
        BibliotecaController controller = new BibliotecaController();
        controller.process();
    }
}
