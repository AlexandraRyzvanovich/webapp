package com.epam.webapp.filter;

import com.epam.webapp.entity.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

public class RoleFilter implements Filter {
    private static final Map<String, List<Role>> COMMAND_ROLES = new HashMap<>();
    private static final String LOGIN_PAGE = "/WEB-INF/views/common/login.jsp";

    static {
        COMMAND_ROLES.put("login", Arrays.asList(Role.CLIENT, Role.ADMIN, Role.TRAINER));
        COMMAND_ROLES.put("logout", Arrays.asList(Role.CLIENT, Role.ADMIN, Role.TRAINER));
        COMMAND_ROLES.put("addNewReview", Collections.singletonList(Role.CLIENT));
        COMMAND_ROLES.put("buySubscription", Collections.singletonList(Role.CLIENT));
        COMMAND_ROLES.put("getAvailableSubscriptions", Collections.singletonList(Role.CLIENT));
        COMMAND_ROLES.put("getInterns", Collections.singletonList(Role.TRAINER));
        COMMAND_ROLES.put("getReviews", Arrays.asList(Role.CLIENT, Role.ADMIN, Role.TRAINER));
        COMMAND_ROLES.put("getClients", Collections.singletonList(Role.ADMIN));
        COMMAND_ROLES.put("setTrainer", Collections.singletonList(Role.ADMIN));
        COMMAND_ROLES.put("getProgram", Collections.singletonList(Role.CLIENT));
        COMMAND_ROLES.put("setBonus", Collections.singletonList(Role.ADMIN));
        COMMAND_ROLES.put("updateProgramStatus", Arrays.asList(Role.CLIENT, Role.TRAINER));
        COMMAND_ROLES.put("setDiet", Collections.singletonList(Role.TRAINER));
        COMMAND_ROLES.put("setTrainingProgram", Collections.singletonList(Role.TRAINER));
        COMMAND_ROLES.put("getInternTrainerProgram", Collections.singletonList(Role.TRAINER));
    }

    private ArrayList<String> urlList;

    @Override
    public void init(FilterConfig filterConfig) {
        String urls = filterConfig.getInitParameter("avoid-urls");
        StringTokenizer token = new StringTokenizer(urls, ",");
        urlList = new ArrayList<>();
        while (token.hasMoreTokens()) {
            urlList.add(token.nextToken());
        }

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        String url = request.getServletPath();
        boolean allowedRequest = false;
        if (urlList.contains(url)) {
            allowedRequest = true;
        }
        if (!allowedRequest) {
            String command = request.getParameter("command");
            HttpSession session = request.getSession(false);
            if(session != null) {
                Object objRole = session.getAttribute("role");
                if (objRole != null) {
                    Role role = Role.valueOf(objRole.toString());
                    List<Role> roles = COMMAND_ROLES.get(command);
                    if (roles != null && !roles.contains(role)) {
                        RequestDispatcher dispatcher = request.getRequestDispatcher(LOGIN_PAGE);
                        dispatcher.forward(request, res);
                        return;
                    }
                }
            }
            filterChain.doFilter(request, res);
        }
    }

    @Override
    public void destroy() {

    }
}

