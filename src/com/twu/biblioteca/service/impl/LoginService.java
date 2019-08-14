package com.twu.biblioteca.service.impl;

import com.twu.biblioteca.controller.Request;
import com.twu.biblioteca.controller.Response;
import com.twu.biblioteca.dao.impl.UsersDao;
import com.twu.biblioteca.domain.User;
import com.twu.biblioteca.service.IBibliotecaService;
import com.twu.biblioteca.view.LoginPage;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;

public class LoginService implements IBibliotecaService {
    private LoginPage page = new LoginPage();
    private Response response = new Response();
    private UsersDao dao = UsersDao.getInstance();

    @Override
    public Response exec(PrintStream printStream, Request request) {
        Map<String,String> userInfo = page.print(printStream);
        List<User> userList = dao.getUserList();
        boolean flag = false;
        for(User user:userList){
            if(user.getId().equals(userInfo.get("id")) & user.getPassword().equals(userInfo.get("password"))){
                flag = true;
                response.setUser(user);
                break;
            }
        }
        if(!flag){
            page.printError(printStream);
            response.setData(-1);
        }
        return response;
    }
}
