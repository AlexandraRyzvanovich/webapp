package com.epam.webapp.filter;

import com.epam.webapp.entity.Role;
import com.mysql.cj.Session;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RoleFilter implements Filter {
    private FilterConfig filterConfig;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        Role type = (Role) session.getAttribute("userType");
        if (type == Role.CLIENT) {

            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/views/clientMenu.jsp");
            dispatcher.forward(req, resp);
            return;
        } else if (type == Role.TRAINER) {

            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/views/trainerMenu.jsp");
            dispatcher.forward(req, resp);
            return;
        }
        // pass the request along the filter chain
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
