package com.twu.biblioteca.service;

import com.twu.biblioteca.controller.Request;
import com.twu.biblioteca.domain.User;
import com.twu.biblioteca.service.impl.*;
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
public class CheckoutAndReturnForUserServiceTest {
    private CheckoutForUserService checkoutService;
    private ReturnForUserService returnService;
    private UserInfoService userInfoService;
    private PrintStream printStream;
    private Request request;
    private User user;

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();


    @Before
    public void setUp(){
        checkoutService = new CheckoutForUserService();
        returnService = new ReturnForUserService();
        userInfoService = new UserInfoService();
        printStream = mock(PrintStream.class);
        request = new Request();
        user = new User("001-0001","1234");
        request.setUser(user);
    }


    @Test
    public void test01_shouldPrintCheckoutSuccess(){
        //be careful the order of provideLines is should be reversed against the normal order.
        systemInMock.provideLines("#");
        systemInMock.provideLines("2");
        checkoutService.exec(printStream,request);
        verify(printStream,atLeast(1)).println("Please input the book id you want(return to the menu please input #):");
        verify(printStream,atLeast(1)).println("Thank you! Enjoy the book");
        verify(printStream,atLeast(1)).println("Please input the book id you want(return to the menu please input #):");
        userInfoService.exec(printStream,request);
        verify(printStream,atLeast(1)).println("Here is your profile:");
        verify(printStream,atLeast(1)).println("User{" +
                "id=" + user.getId() +
                ", password='" + user.getPassword() + '\'' +
                '}'+"\n"+"your checkout books: "+"2");

    }

    @Test
    public void test02_shouldPrintCheckoutError(){
        user.getCheckoutBooks().add(2);  //Be careful, user object is not singleton
        systemInMock.provideLines("#");
        systemInMock.provideLines("2");
        checkoutService.exec(printStream,request);
        verify(printStream,atLeast(1)).println("Please input the book id you want(return to the menu please input #):");
        verify(printStream,atLeast(1)).println("Sorry,that book is not available.");
        verify(printStream,atLeast(1)).println("Please input the book id you want(return to the menu please input #):");
        userInfoService.exec(printStream,request);
        verify(printStream,atLeast(1)).println("Here is your profile:");
        verify(printStream,atLeast(1)).println("User{" +
                "id=" + user.getId() +
                ", password='" + user.getPassword() + '\'' +
                '}'+"\n"+"your checkout books: "+"2");
    }

    @Test
    public void test03_shouldPrintReturnSuccess(){
        user.getCheckoutBooks().add(2);  //Be careful, user object is not singleton

        systemInMock.provideLines("#");
        systemInMock.provideLines("2");
        returnService.exec(printStream,request);
        verify(printStream,atLeast(1)).println("Please input the book id you want to return(return to the menu please input #):");
        verify(printStream,atLeast(1)).println("Thank you for returning the book");
        verify(printStream,atLeast(1)).println("Please input the book id you want to return(return to the menu please input #):");
        userInfoService.exec(printStream,request);
        verify(printStream,atLeast(1)).println("Here is your profile:");
        verify(printStream,atLeast(1)).println("User{" +
                "id=" + user.getId() +
                ", password='" + user.getPassword() + '\'' +
                '}'+"\n"+"your checkout books: ");
    }

    @Test
    public void test04_shouldPrintReturnError(){
        systemInMock.provideLines("#");
        systemInMock.provideLines("2");
        returnService.exec(printStream,request);
        verify(printStream,atLeast(1)).println("Please input the book id you want to return(return to the menu please input #):");
        verify(printStream,atLeast(1)).println("That is not a valid book to return.");
        verify(printStream,atLeast(1)).println("Please input the book id you want to return(return to the menu please input #):");
        userInfoService.exec(printStream,request);
        verify(printStream,atLeast(1)).println("Here is your profile:");
        verify(printStream,atLeast(1)).println("User{" +
                "id=" + user.getId() +
                ", password='" + user.getPassword() + '\'' +
                '}'+"\n"+"your checkout books: ");
    }

}
