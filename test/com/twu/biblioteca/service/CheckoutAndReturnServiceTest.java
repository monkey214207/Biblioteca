package com.twu.biblioteca.service;

import com.twu.biblioteca.service.impl.BookListService;
import com.twu.biblioteca.service.impl.CheckoutService;
import com.twu.biblioteca.service.impl.ReturnService;
import org.junit.*;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.runners.MethodSorters;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.mockito.Mockito.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CheckoutAndReturnServiceTest {
    private CheckoutService checkoutService;
    private ReturnService returnService;
    private PrintStream printStream;

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();


    @Before
    public void setUp(){
        checkoutService = new CheckoutService();
        returnService = new ReturnService();
        printStream = mock(PrintStream.class);
    }


    @Test
    public void test01_shouldPrintCheckoutSuccess(){
        //be careful the order of provideLines is should be reversed against the normal order.
        systemInMock.provideLines("#");
        systemInMock.provideLines("2");
        checkoutService.exec(printStream);
        verify(printStream,atLeast(1)).println("Please input the book id you want(return to the menu please input #):");
        verify(printStream,atLeast(1)).println("Thank you! Enjoy the book");
        verify(printStream,atLeast(1)).println("Please input the book id you want(return to the menu please input #):");
    }

    @Test
    public void test02_shouldPrintCheckoutError(){
        systemInMock.provideLines("#");
        systemInMock.provideLines("2");
        checkoutService.exec(printStream);
        verify(printStream,atLeast(1)).println("Please input the book id you want(return to the menu please input #):");
        verify(printStream,atLeast(1)).println("Sorry,that book is not available.");
        verify(printStream,atLeast(1)).println("Please input the book id you want(return to the menu please input #):");
    }

    @Test
    public void test03_shouldPrintReturnSuccess(){
        systemInMock.provideLines("#");
        systemInMock.provideLines("2");
        returnService.exec(printStream);
        verify(printStream,atLeast(1)).println("Please input the book id you want to return(return to the menu please input #):");
        verify(printStream,atLeast(1)).println("Thank you for returning the book");
        verify(printStream,atLeast(1)).println("Please input the book id you want to return(return to the menu please input #):");
    }

    @Test
    public void test04_shouldPrintReturnError(){
        systemInMock.provideLines("#");
        systemInMock.provideLines("2");
        returnService.exec(printStream);
        verify(printStream,atLeast(1)).println("Please input the book id you want to return(return to the menu please input #):");
        verify(printStream,atLeast(1)).println("That is not a valid book to return.");
        verify(printStream,atLeast(1)).println("Please input the book id you want to return(return to the menu please input #):");
    }

}
