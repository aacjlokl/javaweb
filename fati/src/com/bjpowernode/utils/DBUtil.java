package com.bjpowernode.utils;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServlet;

import java.sql.*;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * JDBC工具类
 *
 */


public class DBUtil {
    //静态变量，也是在类加载时执行
    //并且是有顺序的，自上而下
    private static ResourceBundle bundle = ResourceBundle.getBundle("resources.jdbc");
    //根据key获取value
    private static String Driver = bundle.getString("driver");
    private static String url = bundle.getString("url");
    private static String user = bundle.getString("user");
    private static String pw = bundle.getString("pw");

    static {
        //注册驱动(注册驱动只需要注册一次，放在静态代码块中，DBUtils类加载时执行)
        try {
            //"com.mysql.jdbc.Drver"不能写死，以后可能要连接oracle数据库违背了OCP原则
            Class.forName(Driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库链接对象
     * @return conn 链接对象
     * @throws SQLException
     */

    public static Connection getConnection() throws SQLException {
        //获取连接
        Connection conn = DriverManager.getConnection(url, user, pw);
        return conn;
    }

    public static Connection getConnection(HttpServlet requset) throws SQLException {
        //获取连接
        Connection con = null;
        ServletContext servletContext = requset.getServletContext();
        Map map = (Map) servletContext.getAttribute("key1");
        Iterator it = map.keySet().iterator();
        while(it.hasNext()){
            con = (Connection) it.next();
            boolean flag = (boolean) map.get(con);
            if(flag==true){
                return con;
            }
        }
        return con;
    }

    /**
     * 释放文件
     * @param conn
     * @param ps
     * @param rs
     * @throws SQLException
     */


    public static void colse(Connection conn, Statement ps, ResultSet rs) throws SQLException {
        if(conn != null){
            conn.close();
        }
        if(rs != null){
            rs.close();
        }
        if(ps != null){
            ps.close();
        }
    }
}
