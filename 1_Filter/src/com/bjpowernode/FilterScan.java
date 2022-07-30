package com.bjpowernode;


import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

public class FilterScan implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String age = servletRequest.getParameter("age");
        if(Integer.valueOf(age)<70) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
            else{
                servletRequest.setCharacterEncoding("UTF-8");
                servletResponse.setContentType("text/html,charset=UTF-8");
                PrintWriter out = servletResponse.getWriter();
                out.print("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\n" +
                        "<meta content=\"text/html; charset=utf-8\" http-equiv=\"Content-Type\">\n" +
                        "<meta charset=\"utf-8\">");
                out.print("大爷 珍爱生命啊");
        }

    }
}
