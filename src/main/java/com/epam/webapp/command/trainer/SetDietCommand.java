package com.epam.webapp.command.trainer;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entity.Diet;
import com.epam.webapp.exception.CommandException;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.ProgramService;

import javax.servlet.http.HttpServletRequest;

public class SetDietCommand implements Command {
    private static final String PROGRAM_ID_PARAMETER = "programId";
    private static final String DIET_PARAMETER = "diet";
    private static final String SUCCESS_ATTRIBUTE = "success";
    private static final String SUCCESS_MESSAGE = "You have successfully set diet ";
    private static final String INTERN_CARD_PAGE = "/program?command=getInterns";

    ProgramService programService;

    public SetDietCommand(ProgramService programService) {
        this.programService = programService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        String programIdParameter = request.getParameter(PROGRAM_ID_PARAMETER);
        Long programId = Long.parseLong(programIdParameter);
        String dietParameter = request.getParameter(DIET_PARAMETER);
        Diet diet = Diet.getValue(dietParameter);
        try {
            programService.updateDiet(diet, programId);
            request.setAttribute(SUCCESS_ATTRIBUTE, SUCCESS_MESSAGE);
            return CommandResult.forward(INTERN_CARD_PAGE);
        } catch (ServiceException e) {
            throw new CommandException("Error occurred while executing command", e.getCause());
        }
    }
}
