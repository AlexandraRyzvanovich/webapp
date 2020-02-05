package com.epam.webapp.command.trainer;

import com.epam.webapp.command.Attribute;
import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.command.Page;
import com.epam.webapp.entity.User;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GetInternsCommand implements Command {
    UserService service;

    public GetInternsCommand(UserService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws ServiceException {

        return CommandResult.forward(Page.LOGIN_JSP_PAGE);
    }
}
