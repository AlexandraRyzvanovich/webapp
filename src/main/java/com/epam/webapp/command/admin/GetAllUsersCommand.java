package com.epam.webapp.command.admin;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entity.User;
import com.epam.webapp.exception.CommandException;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GetAllUsersCommand implements Command {
    private static final String CLIENTS_ATTRIBUTE = "clients";
    private static final String TRAINERS_ATTRIBUTE = "trainers";
    private static final String CLIENTS_JSP_PAGE = "/WEB-INF/views/clients.jsp";

    private UserService service;

    public GetAllUsersCommand(UserService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        try {
            List<User> clients = service.getClients();
            List<User> trainers = service.getTrainers();
            request.setAttribute(CLIENTS_ATTRIBUTE, clients);
            request.setAttribute(TRAINERS_ATTRIBUTE, trainers);
            return CommandResult.forward(CLIENTS_JSP_PAGE);
        } catch (ServiceException e) {
            throw new CommandException("Error occurred while executing command", e.getCause());
        }
    }
}
