package com.epam.webapp.command;

import com.epam.webapp.command.admin.GetAllUsersCommand;
import com.epam.webapp.command.client.*;
import com.epam.webapp.command.common.*;
import com.epam.webapp.command.trainer.GetInternsCommand;
import com.epam.webapp.dao.DaoHelperFactory;
import com.epam.webapp.service.*;

public class CommandFactory {
    public static Command create(String command) {

        switch (command){
            case "login": return new LoginCommand(new UserService(new DaoHelperFactory()));
            case "logout": return new LogoutCommand();
            case "main": return new MainCommand();
            case "getTrainingProgram": return new GetTrainingProgramCommand(new TrainingProgramService(new DaoHelperFactory()));
            case "getAvailableSubscriptions": return new GetAvailableSubscriptionsCommand(new SubscriptionService(new DaoHelperFactory()));
            case "getAllUsersCommand": return new GetAllUsersCommand(new UserService(new DaoHelperFactory()));
            case "getReviews": return new GetReviewsCommand(new ReviewService(new DaoHelperFactory()));
            case "getOrders": return new GetOrdersCommand(new OrderService(new DaoHelperFactory()));
            case "addNewReview": return new AddReviewCommand(new ReviewService(new DaoHelperFactory()));
            case "getFoodList" : return new GetFoodListCommand(new TrainingProgramService(new DaoHelperFactory()));
            case "getExerciseList" : return new GetExercisesListCommand(new TrainingProgramService(new DaoHelperFactory()));
            case "getClients": return new ShowPageCommand("/WEB-INF/views/clients.jsp");
            case "getInterns": return new GetInternsCommand(new UserService(new DaoHelperFactory()));


            default: throw new IllegalArgumentException("unknown command " + command);
        }
    }
}
