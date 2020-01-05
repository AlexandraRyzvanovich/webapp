package com.epam.webapp;

import com.epam.webapp.command.Command;
import com.epam.webapp.command.CommandFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
    public void destroy() {
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page;

        try {

            Command cmdHelper= CommandFactory.create(request.getParameter("command"));
            page = cmdHelper.execute(request);

        }
        catch (Exception e) {
            page = "error.jsp";
        }
        dispatch(request, response, page);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        processRequest(request, response);
        HttpSession session = request.getSession();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    public String getServletInfo() {
        return "Front Controller Pattern" +
                " Servlet Front Strategy Example";
    }

    protected void dispatch(HttpServletRequest request, HttpServletResponse response, String page)
            throws  javax.servlet.ServletException,
            IOException {
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }
}


