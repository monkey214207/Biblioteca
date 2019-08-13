package com.twu.biblioteca.domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String id;
    private String password;
    private List<Integer> checkoutBooks;

    public User(String id, String password) {
        this.id = id;
        this.password = password;
        checkoutBooks = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public List<Integer> getCheckoutBooks() {
        return checkoutBooks;
    }

    @Override
    public String toString() {
        String info = "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                '}'+"\n"+"your checkout books: ";
        for(Integer index:checkoutBooks){
            info += index;
        }
        return info;
    }
}
