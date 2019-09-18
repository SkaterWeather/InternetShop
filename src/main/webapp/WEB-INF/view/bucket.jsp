<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="items" scope="request" type="java.util.List<internetshop.model.Item>"/>
<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 18-Sep-19
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Bucket</title>
</head>
<body>
<table>
    Here's your bucket with all items:
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Delete From Bucket</th>
    </tr>
    <c:forEach var="item" items="${items}">
        <tr>
            <td>
                <c:out value="${item.id}" />
            </td>
            <td>
                <c:out value="${item.name}" />
            </td>
            <td>
                <c:out value="${item.price}" />
            </td>
            <td>
                <a href = "<c:url value = "/delete-from-bucket?item_id=${item.id}"/>">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href = "<c:url value = "/order"/>">CREATE ORDER</a>
</body>
</html>
