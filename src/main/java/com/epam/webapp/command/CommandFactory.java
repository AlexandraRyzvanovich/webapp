package com.epam.webapp.command;

import com.epam.webapp.command.client.GetClientProgramCommand;
import com.epam.webapp.command.common.LoginCommand;
import com.epam.webapp.command.common.LogoutCommand;
import com.epam.webapp.command.common.MainCommand;
import com.epam.webapp.dao.DaoHelperFactory;
import com.epam.webapp.service.TrainingProgramService;
import com.epam.webapp.service.UserService;

public class CommandFactory {
    public static Command create(String command) {

        switch (command){
            case "login": return new LoginCommand(new UserService(new DaoHelperFactory()));
            case "logout": return new LogoutCommand();
            case "main": return new MainCommand();
            case "subscripion": return new ShowPageCommand("/WEB-INF/views/subscripion.jsp");
            case "getTrainingProgram": return new GetClientProgramCommand(new TrainingProgramService(new DaoHelperFactory()));
            case "getClients": return new ShowPageCommand("/WEB-INF/views/clients.jsp");

            default: throw new IllegalArgumentException("unknown command " + command);
        }
    }
}
