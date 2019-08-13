package com.twu.biblioteca.service;

import com.twu.biblioteca.dao.impl.BooksDao;
import com.twu.biblioteca.service.impl.BookListService;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BookListServiceTest {
    private BookListService bookListService;
    private PrintStream printStream;

    @Before
    public void setUp(){
        bookListService = new BookListService();
        printStream = mock(PrintStream.class);
    }

    @Test
    public void test01_shouldPrintRightBookList(){
        bookListService.exec(printStream);
        verify(printStream).println("Here are the available books:");
        verify(printStream).println("1 {Agile|Martin Fowler|1993}\n" +"2 {Agile2|Martin Fowler|1994}\n");
    }
}
