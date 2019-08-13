package com.twu.biblioteca.view;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class MenuPage {
    public List<String> getMenuList() {
        return menuList;
    }

    private List<String> menuList = new ArrayList<>();

    public MenuPage() {
        initMenuList();
    }

    private void initMenuList(){
        menuList.add("1.List of books");
        menuList.add("2.Check out a book");
        menuList.add("3.Return a book");
        menuList.add("4.List of movies");
        menuList.add("5.Check out a movie");
        menuList.add("6.Return a movie");
        menuList.add("#.quit");
    }

    public void print(PrintStream printStream) {
        String menuString = "-------------------------------\nHere is the menu:\n";
        for(String index:menuList){
            menuString += index+"\n";
        }
        printStream.println(menuString);
    }
    public void printError(PrintStream printStream){
        printStream.println("Please select a valid option!");
    }
    public void printBye(PrintStream printStream){
        printStream.println("Bye!");
    }
}
