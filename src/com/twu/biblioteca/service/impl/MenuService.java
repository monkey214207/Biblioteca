package com.twu.biblioteca.service.impl;

import com.twu.biblioteca.controller.Request;
import com.twu.biblioteca.controller.Response;
import com.twu.biblioteca.service.IBibliotecaService;
import com.twu.biblioteca.view.MenuPage;

import java.io.PrintStream;
import java.util.Scanner;

public class MenuService implements IBibliotecaService {
    private MenuPage page = new MenuPage();
    private Scanner scanner = new Scanner(System.in);
    private int select;

    @Override
    public Response exec(PrintStream printStream, Request request) {
        page.print(printStream);
        Response response = new Response();
        String command = scanner.nextLine();
        try{
            select = Integer.parseInt(command);
            if(select <= 0 | select > page.getMenuList().size()-1){
                page.printError(printStream);
            }
            else{
                response.setData(select);
            }
        }catch(Exception e){
            if(command.equals("#")){
                page.printBye(printStream);
                response.setData(-1);
            }
            else{
                page.printError(printStream);
            }
        }
        return response;
    }
}
