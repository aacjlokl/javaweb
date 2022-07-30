package com.bjpowernode.oa.web.action;

import com.bjpowernode.oa.utils.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptDropServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html,charset=UTF-8");
        PrintWriter out  = resp.getWriter();
        String deptno = req.getParameter("deptno");
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "delete from dept where deptno = ?";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,deptno);
            int count = ps.executeUpdate();
            if (count == 1){
                req.getRequestDispatcher("/dept/list").forward(req,resp);
            }else{
                req.getRequestDispatcher("/error.html").forward(req,resp);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                DBUtil.colse(conn,ps,null);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
