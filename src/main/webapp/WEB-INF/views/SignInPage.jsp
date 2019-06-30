
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<%--
  Created by IntelliJ IDEA.
  User: alexsey.sultanaev
  Date: 25.06.2019
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file="styles/SignInPageStyle.css"%>
    </style>
    <title>Welcome</title>
</head>
<body>
<div class = "container">
    <h2 class="welcomeText">Account</h2>
    <form method="post">
        <div class = "mainInput">
            <input type="text" name="username" placeholder="username"/>
        </div>
        <div class = "mainInput">
            <input type = "password" name="password" placeholder="password"/>
        </div>
        <input class ="Submit" type="submit" name="submit" value="Sign in"/>
        <br/>
       <c:url value="/web/register" var="registerLink"/>
        <a href="${registerLink}">Register</a>
        <h5 class="infMessage">${informationMessage}</h5>
    </form>
</div>
</body>
</html>
