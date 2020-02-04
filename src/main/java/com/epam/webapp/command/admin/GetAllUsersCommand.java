package com.epam.webapp.command.admin;

import com.epam.webapp.command.Attribute;
import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.command.Page;
import com.epam.webapp.entity.User;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GetAllUsersCommand implements Command {
    UserService service;

    public GetAllUsersCommand(UserService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws ServiceException {
        if (request.getSession(false) != null) {
            List<User> users = service.getAllUsers();
            request.setAttribute(Attribute.USERS_ATTRIBUTE, users);
            return CommandResult.redirect("/clients");
        }
        return CommandResult.forward(Page.LOGIN_JSP_PAGE);
    }
}
