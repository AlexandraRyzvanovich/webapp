package com.epam.webapp.command.common;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.command.Page;
import com.epam.webapp.entity.Role;
import com.epam.webapp.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MainCommand implements Command {

    @Override
    public CommandResult execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession(false);
        String roleSession = session.getAttribute("role").toString();
        Role role = Role.valueOf(roleSession);
        if(role == Role.CLIENT){
            return CommandResult.redirect(Page.TRAINING_PROGRAM_COMMAND_GET_TRAINING_PROGRAM);
        }
        else if(role == Role.TRAINER){
            return CommandResult.redirect(Page.INTERNS_GET_INTERNS_COMMAND);
        }
        else if(role == Role.ADMIN){
            return CommandResult.forward("");
        }
        else throw new CommandException("No such role. Impossible to redirect");
    }
}
