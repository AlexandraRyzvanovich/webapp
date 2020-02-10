package com.epam.webapp.command.admin;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.exception.CommandException;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SetTrainerCommand implements Command {
    private static final String USER_ID_PARAMETER = "user_id";
    private static final String TRAINER_ID_PARAMETER = "trainer_id";
    private static final String SUCCESS_MESSAGE_ATTRIBUTE = "success";
    private static final String MESSAGE_VALUE = "Trainer has been set successfully";
    private static final String CLIENTS_JSP_PAGE = "/WEB-INF/views/clients.jsp";


    private UserService service;

    public SetTrainerCommand(UserService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession(false);
        String userIdParam = request.getParameter(USER_ID_PARAMETER);
        Long userId = Long.parseLong(userIdParam);
        String trainerIdParam = request.getParameter(TRAINER_ID_PARAMETER);
        Long trainerId = Long.parseLong(trainerIdParam);
        try {
            service.addTrainer(userId, trainerId);
            request.setAttribute(SUCCESS_MESSAGE_ATTRIBUTE, MESSAGE_VALUE);
            return CommandResult.redirect(CLIENTS_JSP_PAGE);
        } catch (ServiceException e) {
           throw new CommandException("Error occurred while executing command", e.getCause());
        }
    }
}
