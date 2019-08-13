package com.twu.biblioteca.controller;


import com.twu.biblioteca.service.impl.*;
import com.twu.biblioteca.service.router.CommandRouter;
import com.twu.biblioteca.service.router.Commands;


public class BibliotecaController {
    private  CommandRouter commandRouter;
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
        commandRouter.register(Commands.MOVIELIST.toString(), new MovieListService());
        commandRouter.register(Commands.CHECKOUTMOVIE.toString(), new CheckoutMovieService());
        commandRouter.register(Commands.RETURNMOVIE.toString(), new ReturnMovieService());
    }

    public void process() {
        commandRouter.dispatch(Commands.HOME.toString());
        while (true){
            response = commandRouter.dispatch(Commands.MENU.toString());
            int selectedNum = response.getData();
            if(selectedNum == -1){
                break;
            }
            for (Commands command : Commands.values()) {
                if (command.ordinal() + 1 == selectedNum) {
                    command.action(commandRouter);
                    break;
                }
            }
        }
    }
}
