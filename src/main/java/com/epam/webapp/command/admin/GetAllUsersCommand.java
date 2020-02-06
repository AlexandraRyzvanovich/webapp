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
    private static final String USERS_ATTRIBUTE = "users";
    private static final String CLIENTS_JSP_PAGE = "/WEB-INF/views/clients.jsp";

    private UserService service;

    public GetAllUsersCommand(UserService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        List<User> users;
        try {
            users = service.getAllUsers();
        } catch (ServiceException e) {
            throw new CommandException("Error occurred while executing command", e.getCause());
        }
        request.setAttribute(USERS_ATTRIBUTE, users);
        return CommandResult.forward(CLIENTS_JSP_PAGE);
    }
}
