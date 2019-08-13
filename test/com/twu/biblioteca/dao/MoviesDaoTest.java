package com.twu.biblioteca.dao;


import com.twu.biblioteca.dao.impl.MoviesDao;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MoviesDaoTest {
    private MoviesDao moviesDao;
    private PrintStream printStream;

    @Before
    public void setUp(){
        moviesDao = MoviesDao.getInstance();
        printStream = mock(PrintStream.class);
    }
    //book list
    @Test
    public void test01_shouldPrintTwoBooks(){
        moviesDao.bookList(printStream);
        verify(printStream).println("1 {Harry Potter1|2001|Chris Columbus|9}\n" +"2 {Harry Potter2|2002|Chris Columbus|8}\n");
    }
    //add
    @Test
    public void test02_shouldPrintThreeBooksAfterAdd(){
        moviesDao.add("Harry Potter3","2003","Chris Columbus",8);
        moviesDao.bookList(printStream);
        verify(printStream).println("1 {Harry Potter1|2001|Chris Columbus|9}\n" +"2 {Harry Potter2|2002|Chris Columbus|8}\n" +
                "3 {Harry Potter3|2003|Chris Columbus|8}\n");
    }
    //checkout
    @Test
    public void test03_shouldReturnTrueWhenInputARightIdToCheckout(){
        assertThat(moviesDao.checkoutABook(3),is(true));
    }

    @Test
    public void test04_shouldReturnFalseWhenInputAWrongIdToCheckout(){
        assertThat(moviesDao.checkoutABook(3),is(false));
    }
    //return
    @Test
    public void test05_shouldReturnTrueWhenInputARightIdToReturn(){
        assertThat(moviesDao.returnABook(3),is(true));
    }

    @Test
    public void test06_shouldReturnFalseWhenInputAWrongIdToReturn(){
        assertThat(moviesDao.returnABook(3),is(false));
    }

}
