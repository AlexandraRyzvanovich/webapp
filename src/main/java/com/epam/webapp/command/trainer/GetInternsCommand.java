package com.epam.webapp.command.trainer;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entity.User;
import com.epam.webapp.exception.CommandException;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GetInternsCommand implements Command {
    private static final String ID_ATTRIBUTE = "id";
    private static final String INTERNS_ATTRIBUTE = "interns";
    private static
    UserService service;

    public GetInternsCommand(UserService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession(false);
        Object idAttribute = session.getAttribute(ID_ATTRIBUTE);
        String stringId = idAttribute.toString();
        Long id = Long.parseLong(stringId);
        try {
            List<User> internsList = service.getInterns(id);
            request.setAttribute(INTERNS_ATTRIBUTE, internsList);
            return CommandResult.forward("Page.LOGIN_JSP_PAGE");
        } catch (ServiceException e) {
            throw new CommandException("Error occurred while executing command", e.getCause());
        }
    }
}
