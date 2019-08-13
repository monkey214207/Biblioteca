package com.twu.biblioteca.dao.impl;

import com.twu.biblioteca.dao.IBibliotecaDao;
import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Movie;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class MoviesDao implements IBibliotecaDao {
    private List<Movie> movieList = new ArrayList<>();
    private Integer movieNum = 0;
    private Integer actualMovieNum = 0;
    private List<Integer> checkoutList  = new ArrayList<>();

    private static volatile MoviesDao moviesDao;

    private MoviesDao() {
        init();
    }


    public static MoviesDao getInstance() {
        if (moviesDao == null) {
            synchronized (MoviesDao.class) {
                if (moviesDao == null) {
                    moviesDao = new MoviesDao();
                }
            }
        }
        return moviesDao;
    }

    private void init() {
        //Integer id, String name, String year, String director, Integer rating
        add("Harry Potter1","2001","Chris Columbus",9);
        add("Harry Potter2","2002","Chris Columbus",8);
    }

    public void add(String name, String year, String director, Integer rating) {
        movieNum ++;
        actualMovieNum ++;
        movieList.add(new Movie(movieNum,name,year,director,rating));
    }


    @Override
    public boolean checkoutABook(Integer id) {
        if(!checkoutList.contains(id) & id<= movieNum & id > 0){
            actualMovieNum --;
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
            actualMovieNum ++;
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
        for(Movie movie:movieList){
            if(!checkoutList.contains(movie.getId()))
                printList += movie+"\n";
        }
        printStream.println(printList);
    }
}
