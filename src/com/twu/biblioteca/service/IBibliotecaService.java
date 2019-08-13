package com.twu.biblioteca.service;

import com.twu.biblioteca.controller.Response;

import java.io.PrintStream;

public interface IBibliotecaService {
    Response exec(PrintStream printStream);
}
