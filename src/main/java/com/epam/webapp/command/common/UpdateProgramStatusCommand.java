package com.epam.webapp.command.common;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entity.ProgramStatus;
import com.epam.webapp.exception.CommandException;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.ProgramService;

import javax.servlet.http.HttpServletRequest;

public class UpdateProgramStatusCommand implements Command {
    private static final String PROGRAM_ID_PARAMETER = "programId";
    private static final String STATUS_PARAMETER = "status";
    private static final String SUCCESS_MSG_ATTRIBUTE = "success";
    private static final String SUCCESS_MESSAGE = "Program status has been changed";
    private static final String PROGRAM_CARD_JSP_PAGE = "/program?command=getProgram";
    private static final String INTERNS_PAGE = "/program?command=getInterns";

    private final ProgramService programService;

    public UpdateProgramStatusCommand(ProgramService programService) {
        this.programService = programService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        String programIdParameter = request.getParameter(PROGRAM_ID_PARAMETER);
        Long programId = Long.parseLong(programIdParameter);
        String statusParameter = request.getParameter(STATUS_PARAMETER);
        ProgramStatus status = ProgramStatus.getValue(statusParameter);
        try {
            programService.updateStatus(status, programId);
            request.setAttribute(SUCCESS_MSG_ATTRIBUTE, SUCCESS_MESSAGE);
            Object roleObj = request.getSession(false).getAttribute("role");
            String role = roleObj.toString();
            if (role.equals("TRAINER")) {
                return CommandResult.redirect(INTERNS_PAGE);
            } else {
                return CommandResult.redirect(PROGRAM_CARD_JSP_PAGE);
            }
        } catch (ServiceException e) {
            throw new CommandException("Error occurred while executing command", e.getCause());
        }
    }
}
