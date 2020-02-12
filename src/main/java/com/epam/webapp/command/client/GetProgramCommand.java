package com.epam.webapp.command.client;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.dto.TrainingProgramCard;
import com.epam.webapp.entity.Program;
import com.epam.webapp.entity.ProgramStatus;
import com.epam.webapp.exception.CommandException;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.ProgramService;
import com.epam.webapp.service.TrainingProgramCardService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GetProgramCommand implements Command {
    private static final String ID_ATTRIBUTE = "id";
    private static final String CURRENT_TRAINING_PROGRAM_ATTRIBUTE = "currentTrainingProgram";
    private static final String CURRENT_PROGRAM_ATTRIBUTE = "currentProgram";
    private static final String PROGRAM_JSP_PAGE = "/WEB-INF/views/programCard.jsp";
    private static final String PROGRAM_STATUS_LIST_ATTRIBUTE = "programStatusList";

    ProgramService programService;
    TrainingProgramCardService trainingProgramCardService;

    public GetProgramCommand(ProgramService programService, TrainingProgramCardService trainingProgramCardService) {
        this.programService = programService;
        this.trainingProgramCardService = trainingProgramCardService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession(false);
        Object idAttribute = session.getAttribute(ID_ATTRIBUTE);
        String stringId = idAttribute.toString();
        Long id = Long.parseLong(stringId);
        try {
            List<Program> currentProgram = programService.getCurrentProgram(id);
            List<TrainingProgramCard> currentTrainingProgram = null;
            if(currentProgram != null) {
                Long programId = currentProgram.get(0).getId();
                currentTrainingProgram = trainingProgramCardService.getTrainingProgram(programId);
            }
            List<String> programStatusList = new ArrayList<>(ProgramStatus.PROGRAM_STATUS_MAP.keySet());
            request.setAttribute(CURRENT_PROGRAM_ATTRIBUTE, currentProgram);
            request.setAttribute(CURRENT_TRAINING_PROGRAM_ATTRIBUTE, currentTrainingProgram);
            request.setAttribute(PROGRAM_STATUS_LIST_ATTRIBUTE, programStatusList);
            return CommandResult.forward(PROGRAM_JSP_PAGE);
        } catch (ServiceException e) {
            throw new CommandException("Error occurred while executing command", e.getCause());
        }
    }
}
