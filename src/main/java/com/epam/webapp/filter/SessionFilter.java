package com.epam.webapp.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SessionFilter implements Filter {
    private static final String LOGIN_JSP_PAGE = "/WEB-INF/views/common/login.jsp";
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
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        String url = request.getServletPath();
        boolean allowedRequest = false;
        if (urlList.contains(url)) {
            allowedRequest = true;
        }
        if (!allowedRequest) {
            HttpSession session = request.getSession(false);
            if (session == null) {
                RequestDispatcher dispatcher = request.getRequestDispatcher(LOGIN_JSP_PAGE);
                dispatcher.forward(request, res);
                return;
            }
        }
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {

    }
}
