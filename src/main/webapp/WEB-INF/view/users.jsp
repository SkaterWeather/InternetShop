<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="users" scope="request" type="java.util.List<internetshop.model.User>"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Users</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    </head>

    <body>
    <div class = "mainContainer" style="font-family: 'Century Gothic' ">
        <div class="col-sm-2"></div>
        <div class="col-sm-8">
            <div class = "row" style="background-color: #c4cfff; min-height: 10%" >
                <div class="col-sm-10">
                    <h1>All users</h1>
                </div>
                <div class="col-sm-2">
                    <a href = "${pageContext.request.contextPath}/index">Index page</a>
                </div>
            </div>

            <div class = "row" style="min-height: 85%">
                <p>Here's users list:</p>
                <table border="1px">
                    <tr>
                        <th>ID</th>
                        <th>Login</th>
                        <th>Name</th>
                        <th>Surname</th>
                        <th>Delete</th>
                    </tr>
                    <c:forEach var="user" items="${users}">
                        <tr>
                            <td>
                                <c:out value="${user.id}" />
                            </td>
                            <td>
                                <c:out value="${user.login}" />
                            </td>
                            <td>
                                <c:out value="${user.name}" />
                            </td>
                            <td>
                                <c:out value="${user.surname}" />
                            </td>
                            <td>
                                <a href = "<c:url value = "/delete-user?user_id=${user.id}"/>">delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
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
