<%--
  Created by IntelliJ IDEA.
  User: alexsey.sultanaev
  Date: 24.07.2019
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <meta charset="utf-8">
    <style>
        <%@include file="../styles/SignInPageStyle.css"%>
    </style>
    <title>Login</title>
</head>
<body>
<div class="signInForm">
    <form method="post">
        <div class="inputs">
            <h3 class="Account">Account</h3>
            <input type="text" name="username" placeholder="username">
            <input type="password" name="password" placeholder="password">
            <br/>
            <input class="submit" type="submit" value="Sign In">
            <br/>
            <c:url value="/web/register" var="registerLink"/>
            <a href="${registerLink}">Registration</a>
            <p class="informationMessage">${informationMessage}</p>
        </div>
    </form>
</div>
</body>
</html>