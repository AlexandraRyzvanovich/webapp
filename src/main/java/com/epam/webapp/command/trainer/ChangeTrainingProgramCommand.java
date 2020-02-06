package com.epam.webapp.command.trainer;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.TrainingProgramService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ChangeTrainingProgramCommand implements Command {
    TrainingProgramService service;

    public ChangeTrainingProgramCommand(TrainingProgramService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws ServiceException {


        return CommandResult.forward("");
    }
}
