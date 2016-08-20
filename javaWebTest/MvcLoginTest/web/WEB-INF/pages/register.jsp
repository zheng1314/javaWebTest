<%--
  Created by IntelliJ IDEA.
  User: zheng1617
  Date: 16-7-20
  Time: 下午7:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Register</title>
</head>
<div align="center">
    <form action="${pageContext.request.contextPath}/servlet/RegisterServlet" method="post" />
    <table width = "40%" border = "1">
        <tr>
            <td>USERNAME:</td>
            <td>
                <input type="text" name="userName" value="${formBean.userName}">${formBean.errors.userName}
            </td>
        </tr>
        <tr>
            <td>PASSWORD</td>
            <td>
                <input type="password" name="userPwd" value="${formBean.userPwd}">${formBean.errors.userPwd}
            </td>
        </tr>
        <tr>
            <td>REPASSWORD</td>
            <td>
                <Input type="password" name="confirmPwd" value="${formBean.confirmPwd}">${formBean.errors.confirmPwd}
            </td>
        </tr>
        <tr>
            <td>EMAIL</td>
            <td>
                <Input type="text" name="email" value="${formBean.email}">${formBean.errors.email}
            </td>

        </tr>
        <tr>
            <td>BIRTHDAY</td>
            <td>
                <Input type="text" name="birthday" value="${formBean.birthday}">${formBean.errors.birthday}
            </td>
        </tr>
        <tr>
            <td>
                <input type="reset" value="RESET"/>
            </td>
            <td>
                <input type="submit" value="OK"/>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
