package com.epam.webapp.command.client;

import com.epam.webapp.command.Attribute;
import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.command.Page;
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

public class GetExercisesListCommand implements Command {
    TrainingProgramService service;

    public GetExercisesListCommand(TrainingProgramService service) {
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
                String food = program.get().getExerciseList();
                List<String> exercisesList = new ArrayList<>();
                for (String foodItem : food.split(";")) {
                    exercisesList.add(foodItem);
                }
                request.setAttribute(Attribute.EXERCISES_ATTRIBUTE, exercisesList);
                return CommandResult.forward(Page.EXERCISES_JSP_PAGE);
            }
        }
        return CommandResult.redirect(Page.LOGIN_JSP_PAGE);
    }

}
