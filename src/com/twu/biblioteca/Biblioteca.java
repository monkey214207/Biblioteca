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
    private Integer bookNum = 0;
    private Integer actualBookNum = 0;
    private List<Integer> checkoutList  = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);




    public Biblioteca(PrintStream printStream) {
        initBookList();
        initMenuList();
        this.printStream = printStream;
    }

    private void addBook(String name, String author, String year){
        bookNum ++;
        actualBookNum ++;
        bookList.add(new Book(bookNum,name,author,year));
    }

    private void initBookList(){
        addBook("Agile","Martin Fowler","1993");
        addBook("Agile2","Martin Fowler","1994");
    }

    private void initMenuList(){
        menuList.add("1.List of books");
        menuList.add("2.check out a book");
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
            String chooseId = scanner.nextLine();
            switch(chooseId){
                case "1":
                    printBookList();
                    break;
                case "2":
                    checkoutABook();
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
            if(!checkoutList.contains(book.getId()))
            printStream.println(book);
        }
    }

    public void checkoutABook(){
        while(true){
            printBookList();
            printStream.println("Please input the book id you want(return to the menu please input #):");
            Integer id;
            try{
                id = Integer.parseInt(scanner.nextLine());
            }catch(Exception e){
                break;
            }
            if(!checkoutList.contains(id)){
                printStream.println("success! Now you can checkout this book\n");
                actualBookNum --;
                checkoutList.add(id);
            }
            else{
                printStream.println("Wrong number or this booked has been check-out!!\n");
            }
        }

    }
}
