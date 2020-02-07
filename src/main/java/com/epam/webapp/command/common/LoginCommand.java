package com.epam.webapp.command.common;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entity.Role;
import com.epam.webapp.exception.CommandException;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.UserService;
import com.epam.webapp.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class LoginCommand implements Command {
    private static final String LOGIN_ATTRIBUTE = "login";
    private static final String PASSWORD_ATTRIBUTE = "password";
    private static final String ID_ATTRIBUTE = "id";
    private static final String ROLE_ATTRIBUTE = "role";
    private static final String FIRST_NAME_ATTRIBUTE = "first_name";
    private static final String LAST_NAME_ATTRIBUTE = "last_name";
    private static final String LOGIN_JSP_PAGE = "/WEB-INF/views/common/login.jsp";
    private static final String TRAINING_PROGRAM_PAGE = "controller?command=getTrainingProgram";
    private static final String INTERNS_PAGE = "controller?command=getInterns";


    private UserService userService;

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        String login = request.getParameter(LOGIN_ATTRIBUTE);
        String password = request.getParameter(PASSWORD_ATTRIBUTE);
        Optional<User> user;
        try {
            user = userService.login(login, password);
            if (user.isPresent()) {
                Long userId = user.get().getUserId();
                Role role = user.get().getRole();
                String firstName = user.get().getFirstName();
                String lastName = user.get().getLastName();
                HttpSession session = request.getSession();
                session.setAttribute(ID_ATTRIBUTE, userId);
                session.setAttribute(ROLE_ATTRIBUTE, role);
                session.setAttribute(FIRST_NAME_ATTRIBUTE, firstName);
                session.setAttribute(LAST_NAME_ATTRIBUTE, lastName);
                if (role == Role.CLIENT) {
                    return CommandResult.forward("/WEB-INF/views/main.jsp");
                } else if (role == Role.TRAINER) {
                    return CommandResult.redirect(INTERNS_PAGE);
                } else if (role == Role.ADMIN) {
                    return CommandResult.forward("/WEB-INF/views/main.jsp");
                }
            }
            return CommandResult.redirect(LOGIN_JSP_PAGE);
        } catch (ServiceException e) {
            throw new CommandException("Error occurred while executing command", e.getCause());
        }
    }
}

