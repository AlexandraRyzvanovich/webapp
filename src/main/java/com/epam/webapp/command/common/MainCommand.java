package com.epam.webapp.command.common;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entity.Role;
import com.epam.webapp.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class MainCommand implements Command {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, SQLException, IOException {
        HttpSession session = request.getSession(false);
        String roleSession = session.getAttribute("role").toString();
        Role role = Role.valueOf(roleSession);
        if(role == Role.CLIENT){
            return CommandResult.forward("/training-program?command=getTrainingProgram" );
        }
        else if(role == Role.TRAINER){
            return CommandResult.forward("/clients?command=getClients");
        }else {
            return CommandResult.forward("");
        }

    }
}
