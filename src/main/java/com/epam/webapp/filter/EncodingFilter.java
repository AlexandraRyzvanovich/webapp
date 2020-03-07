package com.epam.webapp.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {

    private String encoding;

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        String codeRequest = request.getCharacterEncoding();
        if (!encoding.equalsIgnoreCase(codeRequest)) {
            request.setCharacterEncoding(encoding);
            response.setCharacterEncoding(encoding);
        }
        filterChain.doFilter(request, response);
    }

    public void init(FilterConfig filterConfig) {
        encoding = filterConfig.getInitParameter("requestEncoding");
        if (encoding == null) encoding = "UTF-8";
    }

    public void destroy() {

    }
}
