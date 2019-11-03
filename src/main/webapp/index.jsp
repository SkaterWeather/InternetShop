<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 15-Sep-19
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>InternetShop</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    </head>
    <body>
    <div id = "topside">
        <div id = "menu">
            <ul>
                <li><a href = "<c:url value = "/login"/>">Login</a> ·</li>
                <li><a href="about.html">About disciplines</a> ·</li>
                <li><a href="shedule.html">Shedule</a> ·</li>
                <li><a href="achivements.html">Achivements</a></li>
            </ul>
        </div>
        <div id="header">Wade Wilson</div>
    </div>
        <div class="midside">
            <p>Hello, there's the navigation map of Internet-shop!</p>Here what you can visit:
            <p><a href = "<c:url value = "/register"/>">Create an account</a></p>
            <p><a href = "<c:url value = "/login"/>">Login</a></p>
            <p><a href = "<c:url value = "/items"/>">All items</a></p>
            <p><a href = "<c:url value = "/bucket"/>">My bucket</a></p>
        </div>
    </body>
</html>
