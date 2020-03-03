package com.epam.webapp.command.trainer;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.exception.CommandException;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.TrainingProgramService;

import javax.servlet.http.HttpServletRequest;

public class SetTrainingProgramCommand implements Command {
    private static final String PROGRAM_ID_PARAMETER = "programId";
    private static final String EXERCISE_ID_PARAMETER = "exerciseId";
    private static final String FREQUENCY_PARAMETER = "frequency";
    private static final String INTERN_CARD_PAGE = "/internCard?command=getInterns";

    private final TrainingProgramService trainingProgramService;

    public SetTrainingProgramCommand(TrainingProgramService trainingProgramService) {
        this.trainingProgramService = trainingProgramService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        String programIdParameter = request.getParameter(PROGRAM_ID_PARAMETER);
        Long programId = Long.parseLong(programIdParameter);
        String exerciseIdParameter = request.getParameter(EXERCISE_ID_PARAMETER);
        Long exerciseId = Long.parseLong(exerciseIdParameter);
        String frequencyParameter = request.getParameter(FREQUENCY_PARAMETER);
        Integer frequency = Integer.parseInt(frequencyParameter);
        try {
            trainingProgramService.setTrainingProgram(programId, exerciseId, frequency);
            return CommandResult.forward(INTERN_CARD_PAGE);
        } catch (ServiceException e) {
            throw new CommandException("Error occurred while executing command", e.getCause());
        }
    }
}
