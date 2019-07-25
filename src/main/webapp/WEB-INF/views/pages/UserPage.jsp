<%--
  Created by IntelliJ IDEA.
  User: alexsey.sultanaev
  Date: 24.07.2019
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <style>
        <%@include file="../styles/UserPageStyle.css"%>
    </style>
    <title>${sessionScope.currentUser.username}</title>
</head>
<body>
<div class="headline">
    <div class="menu">
        <ul>
            <li><a href="viewOrders">Orders</a></li>
            <li><a href="logout">LogOut</a></li>
        </ul>
    </div>
</div>
<div class="UserWelcome">
    <h2>Welcome, ${sessionScope.currentUser.username}</h2>
    <h2>You have : ${sessionScope.currentUser.money}$</h2>
</div>
<div class="Catalog">
    <h2>Catalog:</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Amount</th>
        </tr>
        <c:forEach var="flower" items="${flowerList}">
            <tr>
                <td><c:out value="${flower.id}"/></td>
                <td><c:out value="${flower.name}"/></td>
                <td><c:out value="${flower.price}$"/></td>
                <td><c:out value="${flower.amount}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="OrderChoose">
    <form method="post">
        <select name="FlowerId">
            <c:forEach var="flower" items="${flowerList}">
                <option value="${flower.id}"><c:out value="${flower.name}"/></option>
            </c:forEach>
        </select>
        <input type="number" id="amountFld" name="Amount" placeholder="Amount" min="1">
        <input type="submit" id="addBtn" value="Add">
    </form>
</div>
<div class="Basket">
    <h2>Your basket:</h2>
    <c:if test="${ not empty sessionScope.currentBasket.orderItemList}">
    <table border="1">
        <tbody>
        <tr>
            <td>Name</td>
            <td>Count</td>
        </tr>
        <c:forEach var="orderItem" items="${sessionScope.currentBasket.orderItemList}">
            <tr>
                <td> <c:out value="${orderItem.flower.name}"/></td>
                <td> <c:out value="${orderItem.count}"/></td>
            </tr>
        </c:forEach>
        </tbody>
        <h3><c:out value="${informationMessage}"/></h3>
    </table>
    <h4 id = "Price">Price: ${sessionScope.currentBasket.price}$</h4>
    <c:url value="/web/userPage/createOrder" var="createOrderLink"/>
    <a href="${createOrderLink}">Create order</a>
    <c:url value="/web/userPage/clearOrder" var="clearOrderLink"/>
    <a href="${clearOrderLink}">Delete</a>
    </c:if>
</div>
</body>
</html>