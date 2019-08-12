package com.twu.biblioteca.service.impl;

import com.twu.biblioteca.controller.Response;
import com.twu.biblioteca.service.IBibliotecaService;
import com.twu.biblioteca.view.MenuPage;

import java.io.PrintStream;
import java.util.Scanner;

public class MenuService implements IBibliotecaService {
    private MenuPage page = new MenuPage();
    private PrintStream printStream = System.out;
    private Scanner scanner = new Scanner(System.in);
    private String command;

    @Override
    public Response exec() {
        page.print(printStream);
        Response response = new Response();
        String command = scanner.nextLine();
        try{
            response.setData(Integer.parseInt(command));
        }catch(Exception e){
            if(command == "#"){
                response.setData(-1);
            }
            else{
                page.printError(printStream);
            }
        }
        return response;
    }
}
