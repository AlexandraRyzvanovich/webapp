package com.epam.webapp.command;

import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.UserService;
import com.epam.webapp.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Optional;

public class LoginCommand implements Command {
    private static final String LOGIN_PARAM = "login";
    private static final String PASSWORD_PARAM = "password";
    private static final String USER_ATTR = "user";
    UserService userService;

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, SQLException {
       String login = request.getParameter(LOGIN_PARAM);
       String password = request.getParameter(PASSWORD_PARAM);
       Optional<User> user = userService.login(login, password);
       user.ifPresent(u -> request.setAttribute(USER_ATTR, u));
       return CommandResult.redirect("/controller?command=mainPage");
    }
}
