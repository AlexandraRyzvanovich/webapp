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
        CommandResult page;

        try {
            Command cmdHelper = CommandFactory.create(request.getParameter("command"));
            page = cmdHelper.execute(request, response);
        }
        catch (Exception e) {
            page = CommandResult.redirect( "/error.jsp");
        }
        dispatch(request, response, page);
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

    protected void dispatch(HttpServletRequest request, HttpServletResponse response, CommandResult page) throws  javax.servlet.ServletException, IOException {
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(page.getPage());
        dispatcher.forward(request, response);
    }
}



