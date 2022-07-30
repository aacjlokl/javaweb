package com.bjpowernode.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html,charset=UTF-8");
        HttpSession session = req.getSession();
        PrintWriter out  = resp.getWriter();
        Enumeration<String> goodNames = session.getAttributeNames();
        while (goodNames.hasMoreElements()){
            String key = goodNames.nextElement();
            Integer num = (Integer) session.getAttribute(key);
            out.print("物品："+key+"购买了"+num+"件！");
        }
    }
}
