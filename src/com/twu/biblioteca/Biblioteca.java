package com.twu.biblioteca;

import com.twu.biblioteca.domain.Book;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    private List<Book> bookList = new ArrayList<>();
    private PrintStream printStream;



    public Biblioteca(PrintStream printStream) {
        initBookList();
        this.printStream = printStream;
    }

    private void initBookList(){
        bookList.add(new Book("Agile","Martin Fowler","1993"));
        bookList.add(new Book("Agile2","Martin Fowler","1993"));
        bookList.add(new Book("Agile3","Martin Fowler","1993"));
    }

    public void printWelcomeMessage() {
        printStream.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    public void menu() {
        printStream.println("Here is the menu:\n" +
                "1.List of books\n");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if(str.equals("1")){
            printBookList();
        }
        else{
            printStream.println("Please select a valid option!");
        }
    }

    public void printBookList() {
        for(Book book:bookList){
            System.out.println(book);
        }
    }
}
