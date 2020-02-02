package com.epam.webapp.command.common;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entity.TrainingProgram;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.TrainingProgramService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class GetTrainingProgramCommand implements Command {
    private TrainingProgramService service;

    public GetTrainingProgramCommand(TrainingProgramService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws ServiceException, SQLException, IOException {
        if (request.getSession(false) != null) {
            Long id = Long.parseLong(request.getSession(false).getAttribute("id").toString());
            Optional<TrainingProgram> clientProgram = service.getUserProgram(id);
            request.setAttribute("trainingProgram", clientProgram);

            return CommandResult.redirect("/training-program");
        }
        return CommandResult.redirect("/WEB-INF/views/common/login.jsp");
    }
}