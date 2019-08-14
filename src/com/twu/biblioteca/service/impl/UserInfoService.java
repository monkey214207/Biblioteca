package com.twu.biblioteca.service.impl;

import com.twu.biblioteca.controller.Request;
import com.twu.biblioteca.controller.Response;
import com.twu.biblioteca.service.IBibliotecaService;
import com.twu.biblioteca.view.UserInfoPage;

import java.io.PrintStream;

public class UserInfoService implements IBibliotecaService {

    private UserInfoPage page = new UserInfoPage();


    @Override
    public Response exec(PrintStream printStream, Request request) {
        page.print(printStream);
        printStream.println(request.getUser().toString());
        return new Response();
    }
}
