package com.twu.biblioteca.controller;


import com.twu.biblioteca.service.impl.*;
import com.twu.biblioteca.service.router.CommandRouter;
import com.twu.biblioteca.service.router.Commands;


public class BibliotecaController {
    private  CommandRouter commandRouter;
    boolean flag = true;
    Response response = null;

    public BibliotecaController() {
        init();
    }

    private void init() {
        commandRouter = new CommandRouter();
        commandRouter.register(Commands.HOME.toString(), new HomeService());
        commandRouter.register(Commands.MENU.toString(), new MenuService());
        commandRouter.register(Commands.BOOKLIST.toString(), new BookListService());
        commandRouter.register(Commands.CHECKOUT.toString(), new CheckoutService());
        commandRouter.register(Commands.RETURN.toString(), new ReturnService());
    }

    public void process() {
        commandRouter.dispatch(Commands.HOME.toString());
        while (flag){
            response = commandRouter.dispatch(Commands.MENU.toString());
            System.out.println(response.getData());
            if(response.getData()==-1){
                flag = false;
            }
            if(response.getData()==Commands.BOOKLIST.getIndex()){
                commandRouter.dispatch(Commands.BOOKLIST.toString());
            }
            if(response.getData()==Commands.CHECKOUT.getIndex()){
                commandRouter.dispatch(Commands.CHECKOUT.toString());
            }
            if(response.getData()==Commands.RETURN.getIndex()){
                commandRouter.dispatch(Commands.RETURN.toString());
            }
        }
    }
}
