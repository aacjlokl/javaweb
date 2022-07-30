package com.bjpowernode.control;

import com.bjpowernode.dao.QuestionDao;
import com.bjpowernode.entity.Question;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

public class addServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionDao dao = new QuestionDao();
        int result = 0;
        String title = req.getParameter("title");
        String a = req.getParameter("A");
        String b = req.getParameter("B");
        String c = req.getParameter("C");
        String d = req.getParameter("D");
        String answer = req.getParameter("answer");
        Question question = new Question(title,a,b,c,d,answer);

        try {
            result=dao.add(question);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if(result==1){
            req.setAttribute("info","试题添加成功");
        }
        else{
            req.setAttribute("info","试题添加失败");
        }

        req.getRequestDispatcher("/info.jsp").forward(req,resp);
    }
}
