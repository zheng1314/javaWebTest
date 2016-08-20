<%--
  Created by IntelliJ IDEA.
  User: zheng1617
  Date: 16-7-19
  Time: 下午7:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Home</title>
    <script type="text/javascript">
      function doLogout() {
        window.location.href="${PageContext.request.contextPath}/servlet/LogoutServlet";
      }
    </script>
  </head>
  <body>
  <h1>My web Site</h1>
  <hr/>
  <c:if test="${user==null}">
    <a href="${pageContext.request.contextPath}/servlet/RegisterUIServlet" target="_blank">Register</a>
    <a href="${pageContext.request.contextPath}/servlet/LoginUIServlet" >Log in</a>
  </c:if>
  <c:if test="${user!=null}">
      Welcome : ${user.userName}
      <input type="button" value="Log out" onclick="doLogout()">
  </c:if>
  <hr />
  </body>
</html>
