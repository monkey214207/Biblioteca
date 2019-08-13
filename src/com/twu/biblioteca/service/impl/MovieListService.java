package com.twu.biblioteca.service.impl;

import com.twu.biblioteca.controller.Response;
import com.twu.biblioteca.dao.IBibliotecaDao;
import com.twu.biblioteca.dao.impl.MoviesDao;
import com.twu.biblioteca.service.IBibliotecaService;
import com.twu.biblioteca.view.MovieListPage;

import java.io.PrintStream;

public class MovieListService implements IBibliotecaService {

    private IBibliotecaDao dao = MoviesDao.getInstance();
    private MovieListPage page = new MovieListPage();


    @Override
    public Response exec(PrintStream printStream) {
        page.print(printStream);
        dao.bookList(printStream);
        return new Response();
    }
}
