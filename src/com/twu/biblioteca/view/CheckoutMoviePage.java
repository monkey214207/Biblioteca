package com.twu.biblioteca.view;

import java.io.PrintStream;

public class CheckoutMoviePage {

    public void printTip(PrintStream printStream) {
        printStream.println("Please input the movie id you want(return to the menu please input #):");
    }

    public void printSuccess(PrintStream printStream) {
        printStream.println("Thank you! Enjoy the movie");
    }

    public void priintError(PrintStream printStream) {
        printStream.println("Sorry,that movie is not available.");
    }

}
