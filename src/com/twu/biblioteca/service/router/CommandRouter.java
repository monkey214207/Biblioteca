package com.twu.biblioteca.service.router;

import com.twu.biblioteca.controller.Request;
import com.twu.biblioteca.controller.Response;
import com.twu.biblioteca.service.IBibliotecaService;

import java.util.HashMap;

public class CommandRouter {
    HashMap<String, IBibliotecaService> router= new HashMap();
    public void register(String command, IBibliotecaService service) {
        router.put(command,service);
    }

    public Response dispatch(String command, Request request){
            IBibliotecaService service = router.get(command);
            return service.exec(System.out,request);
    }
}
