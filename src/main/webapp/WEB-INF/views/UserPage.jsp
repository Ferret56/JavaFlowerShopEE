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
    <c:set var="userName" value="${user}"/>
    <title>${user.username}</title>
<h1>You are logged as ${user.username}</h1>
</head>
<body>

</body>
</html>
