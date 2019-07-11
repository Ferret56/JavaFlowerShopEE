<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <style>
        <%@include file="../styles/RegisterPageStyle.css"%>
    </style>
    <title>Registration</title>
</head>
<body>
<div class = "container">
    <h2 class="welcomeText">Create new account</h2>
    <form method="post">
        <div class = "mainInput">
            <input type="text" name="username" placeholder="username"/>
        </div>
        <div class = "mainInput">
            <input type = "password" name="password" placeholder="password"/>
        </div>
        <div class = "mainInput">
            <input type = "password" name="confirm_password" placeholder="confirm password"/>
        </div>
        <br>
        <input class ="Submit" type="submit" name="submit" value="Register"/>
        <h5 class="infMessage">${informationMessage}</h5>
    </form>

</div>
</body>
</html>
