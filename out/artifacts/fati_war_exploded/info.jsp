<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/1/31
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <%
            String info = (String) request.getAttribute("info");
        %>
        <%=info%>
</body>
</html>
