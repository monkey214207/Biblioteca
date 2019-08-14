package com.twu.biblioteca.controller;


import com.twu.biblioteca.service.impl.*;
import com.twu.biblioteca.service.router.CommandRouter;
import com.twu.biblioteca.service.router.Commands;


public class BibliotecaController {
    private  CommandRouter commandRouter;
    Response response = null;
    Request request = new Request();

    public BibliotecaController() {
        init();
    }

    private void init() {
        commandRouter = new CommandRouter();
        commandRouter.register(Commands.HOME.toString(), new HomeService());
        commandRouter.register(Commands.MENU.toString(), new MenuService());
        commandRouter.register(Commands.LOGIN.toString(), new LoginService());
        commandRouter.register(Commands.USERINFO.toString(), new UserInfoService());
        commandRouter.register(Commands.BOOKLIST.toString(), new BookListService());
        commandRouter.register(Commands.CHECKOUT.toString(), new CheckoutForUserService());
        commandRouter.register(Commands.RETURN.toString(), new ReturnForUserService());
        commandRouter.register(Commands.MOVIELIST.toString(), new MovieListService());
        commandRouter.register(Commands.CHECKOUTMOVIE.toString(), new CheckoutMovieService());
        commandRouter.register(Commands.RETURNMOVIE.toString(), new ReturnMovieService());
    }

    public void process() {
        commandRouter.dispatch(Commands.HOME.toString(),request);
        response = commandRouter.dispatch(Commands.LOGIN.toString(),request);
        int selectedNum = response.getData();
        if(selectedNum == -1){
            return;
        }
        request.setUser(response.getUser());
        while (true){
            response = commandRouter.dispatch(Commands.MENU.toString(),request);
            selectedNum = response.getData();
            if(selectedNum == -1){
                break;
            }
            for (Commands command : Commands.values()) {
                if (command.ordinal() + 1 == selectedNum) {
                    command.action(commandRouter,request);
                    break;
                }
            }
        }
    }
}
