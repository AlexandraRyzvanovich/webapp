package com.epam.webapp.command.trainer;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class GetInternsCommand implements Command {
    UserService service;

    public GetInternsCommand(UserService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request)  {

        return CommandResult.forward("Page.LOGIN_JSP_PAGE");
    }
}
