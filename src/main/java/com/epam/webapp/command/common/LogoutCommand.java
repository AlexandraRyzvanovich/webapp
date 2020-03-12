package com.epam.webapp.command.common;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {
    private static final String LOGIN_JSP_PAGE = "/WEB-INF/views/common/login.jsp";

    @Override
    public CommandResult execute(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return CommandResult.redirect(LOGIN_JSP_PAGE);
    }
}
