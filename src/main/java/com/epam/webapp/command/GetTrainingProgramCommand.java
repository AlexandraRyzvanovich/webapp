package com.epam.webapp.command;

import com.epam.webapp.service.TrainingProgramService;

import javax.servlet.http.HttpServletRequest;

public class GetTrainingProgramCommand implements Command {
    private TrainingProgramService service;

    public GetTrainingProgramCommand(TrainingProgramService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request)  {

        return CommandResult.redirect("");
    }
}