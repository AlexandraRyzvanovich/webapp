package com.epam.webapp.command.client;

import com.epam.webapp.command.*;
import com.epam.webapp.entity.TrainingProgram;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.TrainingProgramService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GetFoodListCommand implements Command {
    TrainingProgramService service;

    public GetFoodListCommand(TrainingProgramService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws ServiceException, SQLException, IOException {

        HttpSession session = request.getSession(false);
        if(session != null) {
            String idAttr = session.getAttribute(Attribute.ID_ATTRIBUTE).toString();
            Long id = Long.parseLong(idAttr);
            Optional<TrainingProgram> program = service.getUserProgram(id);
            if(program.isPresent()){
                String food = program.get().getFoodList();
                List<String> foodList = new ArrayList<>();
                for (String foodItem : food.split(";")) {
                    foodList.add(foodItem);
                }
                request.setAttribute(Attribute.FOOD_LIST_ATTRIBUTE, foodList);
            return CommandResult.forward(Page.DIET_JSP_PAGE);
            }
        }
        return CommandResult.redirect(Page.LOGIN_JSP_PAGE);
    }
}
