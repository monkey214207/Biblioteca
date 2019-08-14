package com.twu.biblioteca.service;

import com.twu.biblioteca.controller.Request;
import com.twu.biblioteca.controller.Response;

import java.io.PrintStream;

public interface IBibliotecaService {
    Response exec(PrintStream printStream, Request request);
}
