package com.twu.biblioteca.service.router;

public enum Commands {
    BOOKLIST{
        @Override
        public void action(CommandRouter commandRouter) {
            commandRouter.dispatch(BOOKLIST.toString());
        }
    },
    CHECKOUT {
        @Override
        public void action(CommandRouter commandRouter) {
            commandRouter.dispatch(CHECKOUT.toString());
        }
    },
    RETURN {
        @Override
        public void action(CommandRouter commandRouter) {
            commandRouter.dispatch(RETURN.toString());
        }
    },
    HOME {
        @Override
        public void action(CommandRouter commandRouter) {

        }
    },
    MENU {
        @Override
        public void action(CommandRouter commandRouter) {

        }
    };
    public abstract void action(CommandRouter commandRouter);

}
