package com.epam.webapp.command.client;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entity.TrainingProgram;
import com.epam.webapp.exception.ServiceException;
import com.epam.webapp.service.TrainingProgramService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;
import com.google.gson.Gson;

public class GetTrainingProgramCommand implements Command {
   private TrainingProgramService service;
   private Gson gson;

    public GetTrainingProgramCommand(TrainingProgramService service) {
        this.service = service;
        gson = new Gson();
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException, SQLException, IOException {
        if(request.getSession(false) != null) {

            Long id = Long.parseLong(request.getSession(false).getAttribute("id").toString());
            Optional<TrainingProgram> clientProgram = service.getUserProgram(id);
            String employeeJsonString = this.gson.toJson(clientProgram);
            request.setAttribute("dscsc",employeeJsonString);
            response.setHeader("Location", "http://localhost:8181/training-program");


            return CommandResult.redirect("/WEB-INF/views/training-program.jsp");
        }
        return CommandResult.forward("");
    }
}