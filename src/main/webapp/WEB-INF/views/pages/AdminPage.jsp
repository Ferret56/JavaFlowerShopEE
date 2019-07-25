<%--
  Created by IntelliJ IDEA.
  User: alexsey.sultanaev
  Date: 24.07.2019
  Time: 16:42
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
        <%@include file="../styles/AdminPageStyle.css"%>
    </style>
    <title>Admin</title>
</head>
<body>
<div class="headline">
    <div class="menu">
        <ul>
            <li><a href="logout">LogOut</a></li>
        </ul>
    </div>
</div>
<div class="UserWelcome">
    <h2>You are login as 'Admin'</h2>
    <h2>Users list : </h2>
</div>
<div class="users">
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Money</th>
        </tr>
        <c:forEach var = "user" items="${usersList}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <c:url value="/web/admin/user/${user.id}" var="userOrderLink"/>
                <td> <a href="${userOrderLink}"> <c:out value="${user.username}"/> </a></td>
                <td><c:out value="${user.money}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>