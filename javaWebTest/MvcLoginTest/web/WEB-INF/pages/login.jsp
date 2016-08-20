<%--
  Created by IntelliJ IDEA.
  User: zheng1617
  Date: 16-8-18
  Time: 下午8:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Login Page</title>
</head>
<body>
    <form action="${pageContext.request.contextPath }/servlet/LoginServlet" method="post">
        User Name: <input type="text" name="username"><br/>
        User PassWord: <input type="password" name="password"><br/>
        <input type="submit" value="login">
    </form>
</body>
</html>
