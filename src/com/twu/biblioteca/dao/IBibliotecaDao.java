package com.twu.biblioteca.dao;

import com.twu.biblioteca.dao.impl.BooksDao;
import com.twu.biblioteca.domain.Book;

import java.io.PrintStream;
import java.util.List;

public interface IBibliotecaDao {
    boolean checkoutABook(Integer id);
    boolean returnABook(Integer id);
    void bookList(PrintStream printStream);

}
