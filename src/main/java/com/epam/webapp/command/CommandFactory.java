package com.epam.webapp.command;

import com.epam.webapp.command.admin.GetAllUsersCommand;
import com.epam.webapp.command.client.GetAvailableSubscriptionsCommand;
import com.epam.webapp.command.client.GetOrdersCommand;
import com.epam.webapp.command.client.GetTrainingProgramCommand;
import com.epam.webapp.command.common.LoginCommand;
import com.epam.webapp.command.common.LogoutCommand;
import com.epam.webapp.command.common.MainCommand;
import com.epam.webapp.dao.DaoHelperFactory;
import com.epam.webapp.service.OrderService;
import com.epam.webapp.service.SubscriptionService;
import com.epam.webapp.service.TrainingProgramService;
import com.epam.webapp.service.UserService;

public class CommandFactory {
    public static Command create(String command) {

        switch (command){
            case "login": return new LoginCommand(new UserService(new DaoHelperFactory()));
            case "logout": return new LogoutCommand();
            case "main": return new MainCommand();
            case "getTrainingProgram": return new GetTrainingProgramCommand(new TrainingProgramService(new DaoHelperFactory()));
            case "getAvailableSubscriptions": return new GetAvailableSubscriptionsCommand(new SubscriptionService(new DaoHelperFactory()));
            case "getAllUsersCommand": return new GetAllUsersCommand(new UserService(new DaoHelperFactory()));
            case "getOrders": return new GetOrdersCommand(new OrderService(new DaoHelperFactory()));
            case "getClients": return new ShowPageCommand("/WEB-INF/views/clients.jsp");

            default: throw new IllegalArgumentException("unknown command " + command);
        }
    }
}
