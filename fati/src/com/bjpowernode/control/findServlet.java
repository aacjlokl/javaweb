package com.bjpowernode.control;

import com.bjpowernode.dao.QuestionDao;
import com.bjpowernode.utils.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class findServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionDao dao = new QuestionDao();
        try {
            List list = dao.findall();
            req.setAttribute("key",list);
            req.getRequestDispatcher("/findall.jsp").forward(req,resp);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
