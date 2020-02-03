package com.epam.webapp.command.trainer;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entity.User;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class GetInternsCommand implements Command {
    private static final String ID_ATTR = "id";
    private static final String REQUEST_ATTR_INTERNS = "interns";

    UserService service;

    public GetInternsCommand(UserService service) {
        this.service = service;
    }

    @Override
    public CommandResult execute(HttpServletRequest request) throws ServiceException, SQLException, IOException {
        HttpSession session = request.getSession(false);
        if(session != null) {
            String idAttr = session.getAttribute(ID_ATTR).toString();
            Long id = Long.parseLong(idAttr);
            List<User> interns = service.getInterns(id);
            request.setAttribute(REQUEST_ATTR_INTERNS, interns);
            String contextPath = request.getContextPath();
            return CommandResult.forward(contextPath + "/clients");
        }
        return CommandResult.forward("/error.jsp");
    }
}
