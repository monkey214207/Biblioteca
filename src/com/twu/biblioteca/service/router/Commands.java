package com.twu.biblioteca.service.router;

import com.twu.biblioteca.controller.Request;

public enum Commands {
    BOOKLIST{
        @Override
        public void action(CommandRouter commandRouter, Request request) {
            commandRouter.dispatch(BOOKLIST.toString(),request);
        }
    },
    CHECKOUT {
        @Override
        public void action(CommandRouter commandRouter, Request request) {
            commandRouter.dispatch(CHECKOUT.toString(),request);
        }
    },
    RETURN {
        @Override
        public void action(CommandRouter commandRouter, Request request) {
            commandRouter.dispatch(RETURN.toString(),request);
        }
    },

    MOVIELIST{
        @Override
        public void action(CommandRouter commandRouter, Request request) {
            commandRouter.dispatch(MOVIELIST.toString(),request);
        }
    },
    CHECKOUTMOVIE {
        @Override
        public void action(CommandRouter commandRouter, Request request) {
            commandRouter.dispatch(CHECKOUTMOVIE.toString(),request);
        }
    },
    RETURNMOVIE {
        @Override
        public void action(CommandRouter commandRouter, Request request) {
            commandRouter.dispatch(RETURNMOVIE.toString(),request);
        }
    },
    USERINFO {
        @Override
        public void action(CommandRouter commandRouter, Request request) {
            commandRouter.dispatch(USERINFO.toString(),request);
        }
    },
    HOME {
        @Override
        public void action(CommandRouter commandRouter, Request request) {

        }
    },
    MENU {
        @Override
        public void action(CommandRouter commandRouter, Request request) {

        }
    },
    LOGIN {
        @Override
        public void action(CommandRouter commandRouter, Request request) {
            commandRouter.dispatch(LOGIN.toString(),request);
        }
    };

    public abstract void action(CommandRouter commandRouter, Request request);

}
