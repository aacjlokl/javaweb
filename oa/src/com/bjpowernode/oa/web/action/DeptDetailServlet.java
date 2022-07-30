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

public class DeptDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html,charset=UTF-8");
        PrintWriter out  = resp.getWriter();
        String deptno = req.getParameter("deptno");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("	<head>");
        out.print("		<meta charset='utf-8'>");
        out.print("		<title>详情页面</title>");
        out.print("	</head>");
        out.print("	<body>");
        out.print("		<h1 align='center'>部门详情</h1>");
        out.print("		<hr />");
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from dept where deptno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,deptno);
            rs = ps.executeQuery();

            if (rs.next()){
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                out.print("部门编号："+deptno+"<br>");
                out.print("部门位置："+loc+"<br>");
                out.print("部门名称："+dname+"<br>");


            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                DBUtil.colse(conn,ps,rs);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        out.print("		<input type='button' value='返回' onclick='window.history.back()()'/>");
        out.print("	</body>");
        out.print("</html>");
    }
}