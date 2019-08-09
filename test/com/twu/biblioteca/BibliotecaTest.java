package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibliotecaTest {
    PrintStream printStream;
    Biblioteca biblioteca;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        biblioteca = new Biblioteca(printStream);
    }

    @Test
    public void testWelcomeMessage() {
        biblioteca.printWelcomeMessage();
        verify(printStream).println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    //本来想模拟输入流，但是不知道怎么弄，放弃

}
