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
    <title>Admin</title>

</head>
<body>

<h1>You are admin!</h1>
<form method = "post">
<input type="submit" value="See All"/>
    <table>
   <c:forEach var = "user" items="${usersList}">
       <tr>
           <td align="left"><c:out value="${user.id}"/></td>
           <td align="center"><c:out value="${user.username}"/></td>
       </tr>
   </c:forEach>
        <a href="logout">LogOut</a>
    </table>
</form>

</body>
</html>
