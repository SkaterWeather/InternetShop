<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="items" scope="request" type="java.util.List<internetshop.model.Item>"/>
<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 18-Sep-19
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Items</title>
</head>
<body>
<table>
    Hello, Welcome to shop, Here's what u can buy:
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Add To Bucket</th>
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
                <a href = "<c:url value = "/add-to-bucket?item_id=${item.id}"/>">add</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
