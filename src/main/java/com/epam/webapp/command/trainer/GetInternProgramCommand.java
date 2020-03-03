package com.epam.webapp.command.trainer;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.dto.TrainingProgramCard;
import com.epam.webapp.entity.Diet;
import com.epam.webapp.entity.Exercise;
import com.epam.webapp.entity.Program;
import com.epam.webapp.entity.ProgramStatus;
import com.epam.webapp.exception.CommandException;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.ExerciseService;
import com.epam.webapp.service.ProgramService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetInternProgramCommand implements Command {
    private static final String ID_PARAMETER = "id";
    private static final String CURRENT_PROGRAM_ATTRIBUTE = "currentProgram";
    private static final String PROGRAM_JSP_PAGE = "/WEB-INF/views/internCard.jsp";
    private static final String PROGRAM_STATUS_LIST_ATTRIBUTE = "programStatusList";
    private static final String EXERCISES_LIST_ATTRIBUTE = "exercises";
    private static final String DIET_LIST_ATTRIBUTE = "dietList";

    ProgramService programService;

    ExerciseService exerciseService;

    public GetInternProgramCommand(ProgramService programService, ExerciseService exerciseService) {
        this.programService = programService;
        this.exerciseService = exerciseService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        String userIdParameter = request.getParameter(ID_PARAMETER);
        Long id = Long.parseLong(userIdParameter);
        try {
            Map<Program, List<TrainingProgramCard>> currentProgram = programService.getFullCurrentTrainingProgramInfo(id);
                List<String> programStatusList = new ArrayList<>(ProgramStatus.PROGRAM_STATUS_MAP.keySet());
                List<Exercise> allExercises = exerciseService.getAllExercises();
                List<String> allDiets = new ArrayList<>(Diet.DIET_MAP.keySet());
                request.setAttribute(DIET_LIST_ATTRIBUTE, allDiets);
                request.setAttribute(EXERCISES_LIST_ATTRIBUTE, allExercises);
                request.setAttribute(CURRENT_PROGRAM_ATTRIBUTE, currentProgram);
                request.setAttribute(PROGRAM_STATUS_LIST_ATTRIBUTE, programStatusList);
            return CommandResult.forward(PROGRAM_JSP_PAGE);
        } catch (ServiceException e) {
            throw new CommandException("Error occurred while executing command", e.getCause());
        }
    }
}

