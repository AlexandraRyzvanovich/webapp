package com.epam.webapp.command.client;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandResult;
import com.epam.webapp.entity.TrainingProgram;
import com.epam.webapp.entity.TrainingProgramStatus;
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
            Long userId = clientProgram.get().getUserId();
            String exerciseDescription = clientProgram.get().getExerciseDescription();
            String dietDescription = clientProgram.get().getDietDescription();
            String additionalInfo = clientProgram.get().getAdditionalInfo();
            String[] foodList = clientProgram.get().getFoodList();
            String[] exerciseList = clientProgram.get().getExerciseList();
            TrainingProgramStatus status = clientProgram.get().getStatus();
            String employeeJsonString = this.gson.toJson(clientProgram);

            request.setAttribute("userId", userId);
            request.setAttribute("exerciseDescription", exerciseDescription);
            request.setAttribute("dietDescription", dietDescription);
            request.setAttribute("additionalInfo", additionalInfo);
           /* PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(employeeJsonString);
            out.flush();*/
            request.setAttribute("dscsc",employeeJsonString);
            response.sendRedirect("/training-program");
            return CommandResult.redirect("/WEB-INF/views/program.jsp");
        }
        return CommandResult.forward("");

    }
}
