package com.twu.biblioteca.dao.impl;

import com.twu.biblioteca.dao.IBibliotecaDao;
import com.twu.biblioteca.domain.Book;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class BooksDao implements IBibliotecaDao {
    private List<Book> bookList = new ArrayList<>();
    private Integer bookNum = 0;
    private Integer actualBookNum = 0;
    private List<Integer> checkoutList  = new ArrayList<>();

    private static volatile BooksDao booksDao;

    private BooksDao() {
        init();
    }


    public static BooksDao getInstance() {
        if (booksDao == null) {
            synchronized (BooksDao.class) {
                if (booksDao == null) {
                    booksDao = new BooksDao();
                }
            }
        }
        return booksDao;
    }

    private void init() {
        add("Agile","Martin Fowler","1993");
        add("Agile2","Martin Fowler","1994");
    }

    public void add(String name, String author, String year) {
        bookNum ++;
        actualBookNum ++;
        bookList.add(new Book(bookNum,name,author,year));
    }


    @Override
    public boolean checkoutABook(Integer id) {
        if(!checkoutList.contains(id) & id<= bookNum & id > 0){
            actualBookNum --;
            checkoutList.add(id);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean returnABook(Integer id) {
        if(checkoutList.contains(id)){
            actualBookNum ++;
            checkoutList.remove(id);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void bookList(PrintStream printStream) {
        String printList = "";
        for(Book book:bookList){
            if(!checkoutList.contains(book.getId()))
                printList += book+"\n";
        }
        printStream.println(printList);
    }
}
