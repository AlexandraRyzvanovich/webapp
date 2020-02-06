package com.epam.webapp.command;

import com.epam.webapp.command.admin.GetAllUsersCommand;
import com.epam.webapp.command.client.*;
import com.epam.webapp.command.common.*;
import com.epam.webapp.command.trainer.GetTrainerInternsCommand;
import com.epam.webapp.dao.DaoHelperFactory;
import com.epam.webapp.service.*;

public class CommandFactory {
    public static Command create(String command) {
        switch (command){
            case "login": return new LoginCommand(new UserService(new DaoHelperFactory()));
            case "logout": return new LogoutCommand();
            case "addNewReview": return new AddReviewCommand(new ReviewService(new DaoHelperFactory()));
            case "buySubscription": return new BuySubscriptionCommand(new OrderService(new DaoHelperFactory()));
            case "getAvailableSubscriptions": return new GetAvailableSubscriptionsCommand(new SubscriptionService(new DaoHelperFactory()));
            case "getOrders": return new GetOrdersCommand(new OrderService(new DaoHelperFactory()));
            case "getInterns": return new GetTrainerInternsCommand(new UserService(new DaoHelperFactory()));


            case "getTrainingProgram": return new GetTrainingProgramCommand(new TrainingProgramService(new DaoHelperFactory()));
            case "getAllUsersCommand": return new GetAllUsersCommand(new UserService(new DaoHelperFactory()));
            case "getReviews": return new GetReviewsCommand(new ReviewService(new DaoHelperFactory()));
            case "getClients": return new ShowPageCommand("/WEB-INF/views/clients.jsp");


            default: throw new IllegalArgumentException("unknown command " + command);
        }
    }
}
