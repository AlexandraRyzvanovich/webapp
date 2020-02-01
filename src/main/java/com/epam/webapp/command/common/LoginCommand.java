package com.epam.webapp.command.common;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entity.Role;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.UserService;
import com.epam.webapp.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Optional;

public class LoginCommand implements Command {
    private static final String LOGIN_PARAM = "login";
    private static final String PASSWORD_PARAM = "password";
    private static final String ROLE_ATTR = "role";
    UserService userService;

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, SQLException {
       String login = request.getParameter(LOGIN_PARAM);
       String password = request.getParameter(PASSWORD_PARAM);
       Optional<User> user = userService.login(login, password);
        if(!user.isPresent()){
            return CommandResult.redirect("/WEB-INF/views/common/login.jsp");
        }
        else {
            Long userId = user.get().getUserId();
            Role role = user.get().getRole();
            String firstName = user.get().getFirstName();
            String lastName = user.get().getLastName();
            HttpSession session = request.getSession();
            session.setAttribute("signed_in", true);
            session.setAttribute("id", userId);
            session.setAttribute(ROLE_ATTR, role);
            request.setAttribute("first_name", firstName);
            request.setAttribute("last_name", lastName);
            return CommandResult.redirect("/login?command=main");
        }
    }
}
