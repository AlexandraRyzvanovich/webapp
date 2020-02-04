package com.epam.webapp.command.trainer;

import com.epam.webapp.command.Attribute;
import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.TrainingProgramService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class ChangeTrainingProgramCommand implements Command {
    TrainingProgramService service;

    public ChangeTrainingProgramCommand(TrainingProgramService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws ServiceException, SQLException, IOException {
        HttpSession session = request.getSession(false);
        String foodValue = request.getParameter(Attribute.FOOD_LIST_ATTRIBUTE);
        String exerciseValue = request.getParameter(Attribute.EXERCISES_ATTRIBUTE);
        String idAttr = session.getAttribute(Attribute.ID_ATTRIBUTE).toString();
        Long id = Long.parseLong(idAttr);
        service.changeTrainingProgram(foodValue, exerciseValue, id);

        return CommandResult.forward("");
    }
}
