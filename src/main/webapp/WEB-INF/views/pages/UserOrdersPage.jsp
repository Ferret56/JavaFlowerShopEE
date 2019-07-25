<%--
  Created by IntelliJ IDEA.
  User: alexsey.sultanaev
  Date: 24.07.2019
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="app.models.User.Roles" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <style>
        <%@include file="../styles/UserOrdersPageStyle.css"%>
    </style>
    <title>Orders</title>
</head>
<body>
<div class="orderBox">
    <c:forEach var="order" items="${ordersList}">
    <div class="order">
        <h4>Order № ${order.id}</h4>
        <h4>Price: ${order.orderCost}$</h4>
        <table border="1">
            <tr>
                <th>Flower</th>
                <th>Count</th>
            </tr>
            <c:forEach var="item" items="${order.orderItemList}">
                <tr>
                    <td><c:out value="${item.flower.name}"/></td>
                    <td><c:out value="${item.count}"/></td>
                </tr>
            </c:forEach>
        </table>
        <c:if test="${sessionScope.currentUser.role eq Roles.ADMIN}">
            <c:url value="/web/admin/remove/order/${order.id}" var="deleteOrderLink"/>
            <a href="${deleteOrderLink}">Delete order</a>
        </c:if>
    </div>
    </c:forEach>
</div>
</body>
</html>