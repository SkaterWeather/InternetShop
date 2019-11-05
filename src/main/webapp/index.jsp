<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>InternetShop</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    </head>

    <body>
        <div class = "mainContainer" style="font-family: 'Century Gothic' ">
            <div class="col-sm-2"></div>
            <div class="col-sm-8">
                <div class = "row" style="background-color: #c4cfff; min-height: 5%" >
                    <div class="col-sm-2">
                        <a href = "${pageContext.request.contextPath}/register">Register</a>
                    </div>
                    <div class="col-sm-2">
                        <a href = "${pageContext.request.contextPath}/login">Login</a>
                    </div>
                    <div class="col-sm-2">
                        <a href = "${pageContext.request.contextPath}/items">All items</a>
                    </div>
                    <div class="col-sm-2">
                        <a href = "${pageContext.request.contextPath}/bucket">My bucket</a>
                    </div>
                    <div class="col-sm-2">
                        <a href = "${pageContext.request.contextPath}/purchase-history">My orders</a>
                    </div>
                    <div class="col-sm-2">
                        <a href = "${pageContext.request.contextPath}/users">Users</a>
                    </div>
                </div>

                <div class = "row" style="min-height: 90%">
                    Hello, anyone! This is my realization of internet shop, the purpose of that project
                    was to create a simple web application focusing on back-end in Java, using and improving
                    knowledge in different technologies of web-development.
                </div>

                <div class = "row" style="background-color: #c4cfff; min-height: 5%">
                    <div class="col-sm-3">
                        Author: <a href = "https://github.com/SkaterWeather/">Maxim Bezyazichny</a>
                    </div>
                    <div class="col-sm-3">
                        This project is MIT licensed.
                    </div>
                </div>
            </div>
            <div class="col-sm-2"></div>
        </div>
    </body>
</html>
