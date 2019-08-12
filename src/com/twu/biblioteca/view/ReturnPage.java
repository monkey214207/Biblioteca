package com.twu.biblioteca.view;

import java.io.PrintStream;

public class ReturnPage {
    public void printTip(PrintStream printStream) {
        printStream.println("Please input the book id you want to return(return to the menu please input #):");
    }

    public void printSuccess(PrintStream printStream) {
        printStream.println("Thank you for returning the book");
    }

    public void priintError(PrintStream printStream) {
        printStream.println("That is not a valid book to return.");
    }
}
