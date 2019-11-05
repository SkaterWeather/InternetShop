<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Registration</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    </head>

    <body>
    <div class = "mainContainer" style="font-family: 'Century Gothic' ">
        <div class="col-sm-2"></div>
        <div class="col-sm-8">
            <div class = "row" style="background-color: #c4cfff; min-height: 10%" >
                <div class="col-sm-10">
                    <h1>Sign Up</h1>
                </div>
                <div class="col-sm-2">
                    <a href = "${pageContext.request.contextPath}/index">Index page</a>
                </div>
            </div>

            <div class = "row" style="min-height: 85%">
                <p>Please fill in this form to create an account.</p>
                <form action="register" method="post">
                    <div class="container">
                        <label for="login"><b>Login</b></label>
                        <input type="text" placeholder="Enter Login" name="login" required> <br/>

                        <label for="password"><b>Password</b></label>
                        <input type="password" placeholder="Enter Password" name="password" required> <br/>

                        <label for="name"><b>Name</b></label>
                        <input type="text" placeholder="Enter First Name" name="name" required> <br/>

                        <label for="surname"><b>Surname</b></label>
                        <input type="text" placeholder="Enter Surname" name="surname" required> <br/>

                        <div class="clearfix">
                            <button type="submit" class="signupbtn">Sign Up</button>
                        </div>
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
