package com.twu.biblioteca.dao.impl;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UsersDao {
    private List<User> userList = new ArrayList<>();
    private static volatile UsersDao usersDao;

    private UsersDao() {
        init();
    }

    public List<User> getUserList() {
        return userList;
    }

    public static UsersDao getInstance() {
        if (usersDao == null) {
            synchronized (UsersDao.class) {
                if (usersDao == null) {
                    usersDao = new UsersDao();
                }
            }
        }
        return usersDao;
    }

    private void init() {
        add("001-0001","1234");
        add("001-0002","1234");
    }

    public void add(String id, String password) {
        userList.add(new User(id,password));
    }
}
