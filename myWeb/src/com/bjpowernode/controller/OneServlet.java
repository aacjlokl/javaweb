package com.bjpowernode.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品名称
        String goodname = req.getParameter("goodname");
        //获取session
        HttpSession session = req.getSession();
        //将选购的商品添加到session
        Integer good_num = (Integer) session.getAttribute(goodname);
        if(good_num==null){
            session.setAttribute(goodname,1);
        }else{
            session.setAttribute(goodname,good_num + 1);
        }
    }
}
