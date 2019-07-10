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
    <style>
        <%@include file="styles/UserPageStyle.css"%>
    </style>

    <title>${sessionScope.currentUser.username}</title>

</head>
<body>

<h1>You are logged as ${sessionScope.currentUser.username}</h1>
<a href="logout" >LogOut</a>
<a href="viewOrders">Orders</a>

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

<br>
<form method="post">
    <select name="FlowerId">
        <c:forEach var="flower" items="${flowerList}">
            <option value="${flower.id}"><c:out value="${flower.name}"/></option>
        </c:forEach>
    </select>
    <select name="Amount">
        <option>1</option>
        <option>2</option>
        <option>3</option>
        <option>4</option>
        <option>5</option>
    </select>
    <input type="submit" value="Add to the basket"/>
</form>

<br>
<div class="basket" >
    <h1>Your basket:</h1>
    <c:if test="${ not empty sessionScope.orderItemsList}">
    <table border="1">
        <tbody>
        <tr>
            <td>Name</td>
            <td>Count</td>
        </tr>
    <c:forEach var="orderItem" items="${sessionScope.orderItemsList}">
        <tr>
       <td> <c:out value="${orderItem.flower.name}"/></td>
       <td> <c:out value="${orderItem.count}"/></td>
        </tr>
    </c:forEach>
        </tbody>
    </table>
        <c:url value="/web/userPage/createOrder" var="createOrderLink"/>
       <a href="${createOrderLink}">Create order</a>
        <c:url value="/web/userPage/clearOrder" var="clearOrderLink"/>
        <a href="${clearOrderLink}">Clear all</a>
    </c:if>



</div>






</body>
</html>
