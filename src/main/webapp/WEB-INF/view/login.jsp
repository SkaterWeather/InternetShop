
<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 22-Sep-19
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
${errorMsg}
<form action="login" method="post">
    <div class="container">
        <h1>Sign In</h1>
        <p>Please fill in this form to login.</p>
        <hr>

        <label for="login"><b>Login</b></label>
        <input type="text" placeholder="Enter Login" name="login" required>

        <label for="password"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" required>

        <div class="clearfix">
            <button type="submit" class="signinbtn">Sign In</button>
        </div>
    </div>
</form>
</body>
</html>
