<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alexsey.sultanaev
  Date: 09.07.2019
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="app.models.User.Roles" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Orders</title>
</head>
<body>

<c:forEach var="order" items="${ordersList}">

    <h3>Order№: <c:out value="${order.id}"/></h3>
    <table border="1">
        <tr>
            <td>Flower</td>
            <td>Count</td>
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

</c:forEach>

</body>
</html>
