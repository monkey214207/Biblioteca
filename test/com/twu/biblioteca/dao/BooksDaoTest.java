package com.twu.biblioteca.dao;

import com.twu.biblioteca.dao.impl.BooksDao;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BooksDaoTest {
    private BooksDao booksDao;
    private PrintStream printStream;

    @Before
    public void setUp(){
        booksDao = BooksDao.getInstance();
        printStream = mock(PrintStream.class);
    }
    //book list
    @Test
    public void test01_shouldPrintTwoBooks(){
        booksDao.bookList(printStream);
        verify(printStream).println("1 {Agile|Martin Fowler|1993}\n" +"2 {Agile2|Martin Fowler|1994}\n");
    }
    //add
    @Test
    public void test02_shouldPrintThreeBooksAfterAdd(){
        booksDao.add("Agile3","Martin Fowler","1995");
        booksDao.bookList(printStream);
        verify(printStream).println("1 {Agile|Martin Fowler|1993}\n" +"2 {Agile2|Martin Fowler|1994}\n" +"3 {Agile3|Martin Fowler|1995}\n");
    }
    //checkout
    @Test
    public void test03_shouldReturnTrueWhenInputARightIdToCheckout(){
        assertThat(booksDao.checkoutABook(3),is(true));
    }

    @Test
    public void test04_shouldReturnFalseWhenInputAWrongIdToCheckout(){
        assertThat(booksDao.checkoutABook(3),is(false));
    }
    //return
    @Test
    public void test05_shouldReturnTrueWhenInputARightIdToReturn(){
        assertThat(booksDao.returnABook(3),is(true));
    }

    @Test
    public void test06_shouldReturnFalseWhenInputAWrongIdToReturn(){
        assertThat(booksDao.returnABook(3),is(false));
    }

}
