<%--
  Created by IntelliJ IDEA.
  User: alexsey.sultanaev
  Date: 24.07.2019
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <style>
        <%@include file="../styles/RegisterPageStyle.css"%>
    </style>
    <title>Registration</title>
</head>
<body>
<div class="registrationForm">
    <form method="post">
        <div class="inputs">
            <h3 class="Account">Create new account</h3>
            <input type="text" name="username" placeholder="username">
            <input type="password" name="password" placeholder="password">
            <input type="password" name="confirm_password" placeholder="confirm password">
            <br/>
            <input class="submit" type="submit" value="Sign up">
            <br/>
            <c:url value="/web/signIn" var="signInLink"/>
            <a href="${signInLink}">Sign in</a>
            <p class="informationMessage">${informationMessage}</p>
        </div>
    </form>
</div>
</body>
</html>