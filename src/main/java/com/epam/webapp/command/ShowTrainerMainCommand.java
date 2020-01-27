package com.epam.webapp.command;

import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.TrainerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

public class ShowTrainerMainCommand implements Command {
    TrainerService trainerService;

    public ShowTrainerMainCommand(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, SQLException {
        String sessionAttr = request.getParameter("signed_in");
        if(sessionAttr != null) {
            String userId = request.getParameter("id");
            Long trainerId = Long.valueOf(userId);
            List<Trainer> trainerClients = trainerService.getAllClients(trainerId);
            request.setAttribute("clients_info", trainerClients);
        }
        return CommandResult.forward("/WEB-INF/views/main.jsp");
    }
}

