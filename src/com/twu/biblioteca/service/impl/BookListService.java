package com.twu.biblioteca.service.impl;

import com.twu.biblioteca.controller.Request;
import com.twu.biblioteca.dao.IBibliotecaDao;
import com.twu.biblioteca.dao.impl.BooksDao;
import com.twu.biblioteca.controller.Response;
import com.twu.biblioteca.service.IBibliotecaService;
import com.twu.biblioteca.view.BookListPage;

import java.io.PrintStream;

public class BookListService implements IBibliotecaService {

    private IBibliotecaDao dao = BooksDao.getInstance();
    private BookListPage page = new BookListPage();


    @Override
    public Response exec(PrintStream printStream, Request request) {
        page.print(printStream);
        dao.bookList(printStream);
        return new Response();
    }
}
