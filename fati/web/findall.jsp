<%@ page import="java.util.List" %>
<%@ page import="com.bjpowernode.entity.Question" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/2/1
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>题目查询</title>
</head>
<body>
    <center>
        <font style="font-size: 35px;color: red">题目查询</font>
        <h1></h1>
        <table  border="1">
            <tr>
                <td>题目名称</td>
                <td>选项A</td>
                <td>选项B</td>
                <td>选项C</td>
                <td>选项D</td>
                <td>答案</td>
            </tr>

        <%List list = (List)request.getAttribute("key");
        for(int i = 0; i<list.size();i++){
            Question q =(Question) list.get(i);
        %>
            <tr>
                <td><%=q.getTitle()%></td>
                <td><%=q.getOptiona()%></td>
                <td><%=q.getOptionb()%></td>
                <td><%=q.getOptionc()%></td>
                <td><%=q.getOptiond()%></td>
                <td><%=q.getAnswer()%></td>
            </tr>
        <%}%>
        </table>
    </center>
</body>
</html>
