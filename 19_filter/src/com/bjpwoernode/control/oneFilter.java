package com.bjpwoernode.control;

import jakarta.servlet.*;

import java.io.IOException;

public class oneFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setContentType("text/html,charset=UTF-8");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
