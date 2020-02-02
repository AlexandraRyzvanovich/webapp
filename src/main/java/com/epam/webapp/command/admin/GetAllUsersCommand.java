package com.epam.webapp.command.admin;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entity.User;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetAllUsersCommand implements Command {
    private static final String USERS_ATTR = "user";
    UserService service;

    public GetAllUsersCommand(UserService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        if (request.getSession(false) != null) {
            List<User> users = service.getAllUsers();
            request.setAttribute(USERS_ATTR, users);
            return CommandResult.redirect("/clients");
        }
        return CommandResult.forward("/WEB-INF/views/common/login.jsp");
    }
}
