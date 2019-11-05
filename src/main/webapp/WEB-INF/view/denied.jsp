<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Denied</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    </head>

    <body>
    <div class = "mainContainer" style="font-family: 'Century Gothic' ">
        <div class="col-sm-2"></div>
        <div class="col-sm-8">
            <div class = "row" style="background-color: #c4cfff; min-height: 10%" >
                <div class="col-sm-10">
                    <h1>Access denied</h1>
                </div>
                <div class="col-sm-2">
                    <a href = "${pageContext.request.contextPath}/index">Index page</a>
                </div>
            </div>

            <div class = "row" style="min-height: 90%">
                <p>Sorry, seems like only users with ADMIN status can visit that page</p>
            </div>
        </div>
        <div class="col-sm-2"></div>
    </div>
    </body>
</html>
