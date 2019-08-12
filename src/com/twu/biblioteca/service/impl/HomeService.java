package com.twu.biblioteca.service.impl;

import com.twu.biblioteca.controller.Response;
import com.twu.biblioteca.service.IBibliotecaService;
import com.twu.biblioteca.view.HomePage;

import java.io.PrintStream;

public class HomeService implements IBibliotecaService {
    private HomePage page = new HomePage();
    private PrintStream printStream = System.out;

    @Override
    public Response exec() {
        page.print(printStream);
        return new Response();
    }
}
