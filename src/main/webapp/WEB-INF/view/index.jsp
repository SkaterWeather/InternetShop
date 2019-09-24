<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 15-Sep-19
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
    <div>
        <p>Hello, there's the navigation map of Internet-shop!</p>Here what you can visit:
        <p><a href = "<c:url value = "/register"/>">Create an account</a></p>
        <p><a href = "<c:url value = "/login"/>">Login</a></p>
        <p><a href = "<c:url value = "/items"/>">All items</a></p>
        <p><a href = "<c:url value = "/bucket"/>">My bucket</a></p>
    </div>
</body>
</html>
