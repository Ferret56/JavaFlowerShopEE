<%--
  Created by IntelliJ IDEA.
  User: alexsey.sultanaev
  Date: 01.07.2019
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<html>
<head>

    <title>${sessionScope.currentUser.username}</title>

</head>
<body>

<h1>You are logged as ${sessionScope.currentUser.username}</h1>
<a href="logout" >LogOut</a>

<h3>Product table:</h3>
<table border="1">
    <tbody>
    <tr>
        <td>ID</td>
        <td>NAME</td>
        <td>PRICE</td>
    </tr>
    <c:forEach var="flower" items="${flowerList}">
        <tr>
            <td><c:out value="${flower.id}"/></td>
            <td><c:out value="${flower.name}"/></td>
            <td><c:out value="${flower.price}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
