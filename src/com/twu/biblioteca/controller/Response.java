package com.twu.biblioteca.controller;

import com.twu.biblioteca.domain.User;

public class Response {
    private int data;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
