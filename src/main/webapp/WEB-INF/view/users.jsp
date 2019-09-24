<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="users" scope="request" type="java.util.List<internetshop.model.User>"/>
<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 18-Sep-19
  Time: 0:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
    <table>
        Here's users list:
        <tr>
            <th>ID</th>
            <th>Login</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Delete</th>
            <th>View Purchase History</th>
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
                <td>
                    <a href = "<c:url value = "/purchase-history"/>">view</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
