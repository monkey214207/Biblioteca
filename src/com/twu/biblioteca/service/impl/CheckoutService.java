package com.twu.biblioteca.service.impl;

import com.twu.biblioteca.controller.Request;
import com.twu.biblioteca.dao.IBibliotecaDao;
import com.twu.biblioteca.dao.impl.BooksDao;
import com.twu.biblioteca.controller.Response;
import com.twu.biblioteca.service.IBibliotecaService;
import com.twu.biblioteca.view.CheckoutPage;

import java.io.PrintStream;
import java.util.Scanner;

public class CheckoutService implements IBibliotecaService {
    private IBibliotecaDao dao = BooksDao.getInstance();
    CheckoutPage page = new CheckoutPage();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public Response exec(PrintStream printStream, Request request) {
        while(true){
            page.printTip(printStream);
            Integer id;
            try{
                id = Integer.parseInt(scanner.nextLine());
            }catch(Exception e){
                break;
            }
            if(dao.checkoutABook(id)){
                page.printSuccess(printStream);
            }
            else{
                page.priintError(printStream);
            }
        }
        return new Response();
    }
}
