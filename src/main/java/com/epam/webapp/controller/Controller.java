package com.epam.webapp.controller;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandFactory;
import com.epam.webapp.command.CommandResult;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        try {
            Command command = CommandFactory.create(request.getParameter("command"));
            CommandResult commandResult = command.execute(request);
            page = commandResult.getPage();

            if(commandResult.isRedirect()) {
                redirect(response, page);
            } else {
                forward(request, response, page);
            }
        }
        catch (Exception e) {
            page = "/error.jsp";
            redirect(response, page);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    public String getServletInfo() {
        return "Front Controller Pattern" +
                " Servlet Front Strategy Example";
    }

    protected void forward(HttpServletRequest request, HttpServletResponse response, String page) throws  ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

    protected void redirect(HttpServletResponse response, String page) throws ServletException, IOException {
        response.sendRedirect(page);
    }
}



