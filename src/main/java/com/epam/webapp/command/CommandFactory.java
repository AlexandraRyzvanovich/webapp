package com.epam.webapp.command;

import com.epam.webapp.dao.DaoHelperFactory;
import com.epam.webapp.service.UserService;

public class CommandFactory {
    public static Command create(String command) {

        switch (command){
            case "login": return new LoginCommand(new UserService(new DaoHelperFactory()));
            case "logout": return new LogoutCommand();
            case "main": return new ShowPageCommand("/WEB-INF/views/main.jsp");
            case "subscripion": return new ShowPageCommand("/WEB-INF/views/subscripion.jsp");
            //case "trainerWork" : return new ShowTrainerMainCommand();

            default: throw new IllegalArgumentException("unknown command " + command);
        }
    }
}
