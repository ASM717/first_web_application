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
<div class="w3-container w3-center">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <h1>Hello, I am a Java First Web App!</h1>
    <p>
        <%
            java.util.Date now = new java.util.Date();
            String time = "Текущее время : " + now;
        %>
        <%= time%>
    </p>
</div>

<div class="w3-container w3-center"> <!-- content -->
    <div class="w3-bar w3-padding-large w3-padding-24"> <!-- buttons -->
        <button class="w3-button w3-pale-blue " onclick="location.href='signUp'">Sign Up</button>
        <button class="w3-button w3-cyan" onclick="location.href='signIn'">Sign In</button>
    </div>
</div>

</body>
</html>
