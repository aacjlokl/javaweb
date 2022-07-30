package com.bjpowernode.dao;

import com.bjpowernode.entity.Question;
import com.bjpowernode.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDao {
    public int add(Question q) throws SQLException {
        String sql = "insert into tiku(title,optiona,optionb,optionc,optiond,answer) value(?,?,?,?,?,?)";
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        int result = 0;
        try {
            ps.setString(1,q.getTitle());
            ps.setString(2,q.getOptiona());
            ps.setString(3,q.getOptionb());
            ps.setString(4,q.getOptionc());
            ps.setString(5,q.getOptiond());
            ps.setString(6,q.getAnswer());
            result = ps.executeUpdate();
        }catch (Exception e){

        }finally {
            DBUtil.colse(con,ps,null);
        }
        return result;
    }

    public List findall() throws SQLException {
        Connection con = DBUtil.getConnection();
        List<Question> list = new ArrayList<Question>();
        String sql = "select * from tiku";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            String title = rs.getString("title");
            String optiona = rs.getString("optiona");
            String optionb = rs.getString("optionb");
            String optionc = rs.getString("optionc");
            String optiond = rs.getString("optiond");
            String answer = rs.getString("answer");
            Question q = new Question(title,optiona,optionb,optionc,optiond,answer);
            list.add(q);
        }
        return list;


    }
}
