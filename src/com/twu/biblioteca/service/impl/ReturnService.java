package com.twu.biblioteca.service.impl;

import com.twu.biblioteca.controller.Response;
import com.twu.biblioteca.dao.IBibliotecaDao;
import com.twu.biblioteca.dao.impl.BooksDao;
import com.twu.biblioteca.service.IBibliotecaService;
import com.twu.biblioteca.view.ReturnPage;

import java.io.PrintStream;
import java.util.Scanner;

public class ReturnService implements IBibliotecaService {
    private IBibliotecaDao dao = BooksDao.getInstance();
    ReturnPage page = new ReturnPage();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public Response exec(PrintStream printStream) {
        while(true){
            page.printTip(printStream);
            Integer id;
            try{
                id = Integer.parseInt(scanner.nextLine());
            }catch(Exception e){
                break;
            }
            if(dao.returnABook(id)){
                page.printSuccess(printStream);
            }
            else {
                page.priintError(printStream);
            }
        }
        return new Response();
    }
}
