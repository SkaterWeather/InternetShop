<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    </head>

    <body>
        <div class = "mainContainer" style="font-family: 'Century Gothic' ">
            <div class="col-sm-2"></div>
            <div class="col-sm-8">
                <div class = "row" style="background-color: #c4cfff; min-height: 10%" >
                    <div class="col-sm-10">
                        <h1>Sign In</h1>
                    </div>
                    <div class="col-sm-2">
                        <a href = "${pageContext.request.contextPath}/index">Index page</a>
                    </div>
                </div>

                <div class = "row" style="min-height: 85%">
                    <p>Please fill in this form to login.</p>
                    <form action="login" method="post">
                        <div class="container">
                            <label for="login"><b>Login</b></label>
                            <input type="text" placeholder="Enter Login" name="login" required>

                            <label for="password"><b>Password</b></label>
                            <input type="password" placeholder="Enter Password" name="password" required>

                            <div class="clearfix">
                                <button type="submit" class="signinbtn">Sign In</button>
                            </div>
                            or
                            <a href = "${pageContext.request.contextPath}/register">Register</a>
                            if you already have an account.
                        </div>
                    </form>
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
