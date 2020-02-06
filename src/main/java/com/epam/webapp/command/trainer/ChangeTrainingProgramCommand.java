package com.epam.webapp.command.trainer;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.service.TrainingProgramService;

import javax.servlet.http.HttpServletRequest;

public class ChangeTrainingProgramCommand implements Command {
    TrainingProgramService service;

    public ChangeTrainingProgramCommand(TrainingProgramService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) {

        return CommandResult.forward("");
    }
}
