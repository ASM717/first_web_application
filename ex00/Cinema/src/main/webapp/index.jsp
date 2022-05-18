<%--
  Created by IntelliJ IDEA.
  User: gastellsky
  Date: 16.05.2022
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FWA</title>
</head>
<body>
<h1>Hello, I am a Java web app!</h1>

<p>
    <%
        java.util.Date now = new java.util.Date();
        String time = "Текущее время : " + now;
    %>
    <%= time%>
</p>

<p>SIGN UP <a href="signUp.jsp">here</a></p>
<p>SIGN IN <a href="signIn.jsp">here</a></p>
</body>
</html>
