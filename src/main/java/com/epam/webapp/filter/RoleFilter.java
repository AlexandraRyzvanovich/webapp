package com.epam.webapp.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

public class RoleFilter implements Filter {
    private static final Map<String, List<String>> COMMAND_ROLES = new HashMap<>();
          static {
              COMMAND_ROLES.put( "login", Arrays.asList("user", "admin", "trainer"));
                      COMMAND_ROLES.put("logout", Arrays.asList("user", "admin", "trainer"));
                      COMMAND_ROLES.put("addNewReview", Arrays.asList("user"));
                      COMMAND_ROLES.put("buySubscription", Arrays.asList("user"));
                      COMMAND_ROLES.put("getAvailableSubscriptions", Arrays.asList("user"));
                      COMMAND_ROLES.put("getInterns", Arrays.asList("trainer"));
                      COMMAND_ROLES.put("getReviews", Arrays.asList("user", "admin", "trainer"));
                      COMMAND_ROLES.put("getClients", Arrays.asList("admin"));
                      COMMAND_ROLES.put("setTrainer", Arrays.asList("trainer"));
                      COMMAND_ROLES.put("getProgram", Arrays.asList("user"));
                      COMMAND_ROLES.put("setBonus", Arrays.asList("admin"));
                      COMMAND_ROLES.put("updateProgramStatus", Arrays.asList("user", "trainer"));
                      COMMAND_ROLES.put("setDiet", Arrays.asList("trainer"));
                      COMMAND_ROLES.put("setTrainingProgram", Arrays.asList("trainer"));
                      COMMAND_ROLES.put("getInternTrainerProgram", Arrays.asList("trainer"));
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
            Object objRole = session.getAttribute("role");
            String role = objRole.toString();
            if (role != null && command != null) {
                for (String commandInMap : COMMAND_ROLES.keySet()) {
                    if (commandInMap.equals(command)) {
                        List<String> valuesByKey = COMMAND_ROLES.get(commandInMap);
                        for (String roleInMap : valuesByKey) {
                            if (roleInMap.equals(role)) {
                                filterChain.doFilter(request, res);
                            }
                        }
                    }
                }
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
        dispatcher.forward(request, res);

    }

    @Override
    public void destroy() {

    }
}
