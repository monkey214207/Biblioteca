package com.twu.biblioteca.view;

import java.io.PrintStream;

public class CheckoutPage {

    public void printTip(PrintStream printStream) {
        printStream.println("Please input the book id you want(return to the menu please input #):");
    }

    public void printSuccess(PrintStream printStream) {
        printStream.println("Thank you! Enjoy the book");
    }

    public void priintError(PrintStream printStream) {
        printStream.println("Sorry,that book is not available.");
    }

}
