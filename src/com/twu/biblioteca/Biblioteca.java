package com.twu.biblioteca;

import com.twu.biblioteca.domain.Book;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    private List<Book> bookList = new ArrayList<>();
    private PrintStream printStream;
    private List<String> menuList = new ArrayList<>();



    public Biblioteca(PrintStream printStream) {
        initBookList();
        initMenuList();
        this.printStream = printStream;
    }

    private void initBookList(){
        bookList.add(new Book("Agile","Martin Fowler","1993"));
        bookList.add(new Book("Agile2","Martin Fowler","1993"));
    }

    private void initMenuList(){
        menuList.add("1.List of books");
        menuList.add("#.quit");
    }

    public void printWelcomeMessage() {
        printStream.println("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!");
    }

    private void printMenu(){
        String menuString = "-------------------------------\nHere is the menu:\n";
        for(String index:menuList){
            menuString += index+"\n";
        }
        printStream.println(menuString);
    }

    public void handleMenu() {
        boolean flag = true;
        while(flag){
            printMenu();
            Scanner scanner = new Scanner(System.in);
            String chooseId = scanner.nextLine();
            switch(chooseId){
                case "1":
                    printBookList();
                    break;
                case "#":
                    printStream.println("Bye!");
                    flag = false;
                    break;
                default:
                    printStream.println("Please select a valid option!");
            }
        }

    }

    public void printBookList() {
        for(Book book:bookList){
            System.out.println(book);
        }
    }
}
