<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Success order</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    </head>

    <body>
    <div class = "mainContainer" style="font-family: 'Century Gothic' ">
        <div class="col-sm-2"></div>
        <div class="col-sm-8">
            <div class = "row" style="background-color: #c4cfff; min-height: 10%" >
                <div class="col-sm-10">
                    <h1>Congratulations!</h1>
                </div>
                <div class="col-sm-2">
                    <a href = "${pageContext.request.contextPath}/index">Index page</a>
                </div>
            </div>

            <div class = "row" style="min-height: 90%">
                <p>You have ordered a purchase.</p>
                <a href = "<c:url value = "/purchase-history"/>">View my purchase history</a>
            </div>
        </div>
        <div class="col-sm-2"></div>
    </div>
    </body>
</html>
