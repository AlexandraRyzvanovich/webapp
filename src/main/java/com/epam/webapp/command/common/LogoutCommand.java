package com.epam.webapp.command.common;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {

    @Override
    public CommandResult execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return CommandResult.redirect("/WEB-INF/views/login.jsp");
    }
}
