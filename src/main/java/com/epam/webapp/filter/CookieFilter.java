package com.epam.webapp.filter;

import com.epam.webapp.ConnectionCookieUtils;
import com.epam.webapp.dao.UserDaoImpl;
import com.epam.webapp.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebFilter(filterName = "cookieFilter", urlPatterns = { "/*" })
public class CookieFilter implements Filter {
    public CookieFilter() {
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        User userInSession = ConnectionCookieUtils.getLoginedUser(session);
        //
        if (userInSession != null) {
            session.setAttribute("COOKIE_CHECKED", "CHECKED");
            chain.doFilter(request, response);
            return;
        }

        // Connection создан в JDBCFilter.
        Connection conn = ConnectionCookieUtils.getStoredConnection(request);

        // Флаг(flag) для проверки Cookie.
        String checked = (String) session.getAttribute("COOKIE_CHECKED");
        if (checked == null && conn != null) {
            String userName = ConnectionCookieUtils.getUserNameInCookie(req);
            UserDaoImpl userDao = new UserDaoImpl(conn);
            Optional<User> user = userDao.getByName(userName);
            ConnectionCookieUtils.storeLoginedUser(session, user);
            // Отметить проверенные Cookie.
            session.setAttribute("COOKIE_CHECKED", "CHECKED");
        }

        chain.doFilter(request, response);
    }
}
