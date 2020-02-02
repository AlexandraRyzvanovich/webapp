package com.epam.webapp.command.common;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.TrainingProgramService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ChangeTrainingProgramCommand implements Command {
    TrainingProgramService service;

    public ChangeTrainingProgramCommand(TrainingProgramService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws ServiceException, SQLException, IOException {
        String foodValue = request.getParameter("food");
        String exerciseValue = request.getParameter("exercises");
        Long id = Long.parseLong(request.getSession(false).getAttribute("id").toString());
        service.changeTrainingProgram(foodValue, exerciseValue, id);

        return null;
    }
}
