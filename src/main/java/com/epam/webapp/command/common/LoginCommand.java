package com.epam.webapp.command.common;

import com.epam.webapp.command.Attribute;
import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.command.Page;
import com.epam.webapp.entity.Role;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.UserService;
import com.epam.webapp.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Optional;

public class LoginCommand implements Command {
    UserService userService;

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws ServiceException, SQLException {
       String login = request.getParameter(Attribute.LOGIN_ATTRIBUTE);
       String password = request.getParameter(Attribute.PASSWORD_ATTRIBUTE);
       Optional<User> user = userService.login(login, password);
        if(!user.isPresent()) {
            return CommandResult.forward(Page.LOGIN_JSP_PAGE);
        }
        else {
            Long userId = user.get().getUserId();
            Role role = user.get().getRole();
            String firstName = user.get().getFirstName();
            String lastName = user.get().getLastName();
            HttpSession session = request.getSession();
            session.setAttribute(Attribute.ID_ATTRIBUTE, userId);
            session.setAttribute(Attribute.ROLE_ATTRIBUTE, role);
            session.setAttribute(Attribute.FIRST_NAME_ATTRIBUTE, firstName);
            session.setAttribute(Attribute.LAST_NAME_ATTRIBUTE, lastName);
            if(role == Role.CLIENT){
                return CommandResult.redirect(Page.TRAINING_PROGRAM_COMMAND_GET_TRAINING_PROGRAM);
            }
            else if(role == Role.TRAINER){
                return CommandResult.redirect(Page.INTERNS_GET_INTERNS_COMMAND);
            }
            else if(role == Role.ADMIN){
                return CommandResult.forward("");
            }
            return CommandResult.forward( Page.LOGIN_MAIN_COMMAND);
        }
    }
}
