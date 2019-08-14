package com.twu.biblioteca.controller;

import com.twu.biblioteca.domain.User;

public class Request {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
