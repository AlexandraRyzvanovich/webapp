package com.epam.webapp.command.common;

import com.epam.webapp.command.Attribute;
import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.command.Page;
import com.epam.webapp.entity.TrainingProgram;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.TrainingProgramService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class GetTrainingProgramCommand implements Command {
    private TrainingProgramService service;

    public GetTrainingProgramCommand(TrainingProgramService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws ServiceException {
        if (request.getSession(false) != null) {
            Long id = Long.parseLong(request.getSession(false).getAttribute(Attribute.ID_ATTRIBUTE).toString());
            Optional<TrainingProgram> clientTrainingProgram = service.getUserProgram(id);
            request.setAttribute(Attribute.TRAINING_PROGRAM_ATTRIBUTE, clientTrainingProgram);

            return CommandResult.forward(Page.TRAINING_PROGRAM_JSP_PAGE);
        }
        return CommandResult.redirect(Page.LOGIN_JSP_PAGE);
    }
}