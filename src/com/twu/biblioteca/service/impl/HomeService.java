package com.twu.biblioteca.service.impl;

import com.twu.biblioteca.controller.Request;
import com.twu.biblioteca.controller.Response;
import com.twu.biblioteca.service.IBibliotecaService;
import com.twu.biblioteca.view.HomePage;

import java.io.PrintStream;

public class HomeService implements IBibliotecaService {
    private HomePage page = new HomePage();

    @Override
    public Response exec(PrintStream printStream, Request request) {
        page.print(printStream);
        return new Response();
    }
}
