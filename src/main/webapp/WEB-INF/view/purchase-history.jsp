<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="history" scope="request" type="java.util.List<internetshop.model.Order>"/>
<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 18-Sep-19
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PurchaseHistory</title>
</head>
<body>
<table>
    Here's your purchase history:
    <tr>
        <th>ID</th>
        <th>Items</th>
        <th>TotalPrice</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="order" items="${history}">
        <tr>
            <td>
                <c:out value="${order.id}" />
            </td>
            <td>
                <c:out value="${order.itemsList}" />
            </td>
            <td>
                <c:out value="${order.totalPrice}" />
            </td>
            <td>
                <a href = "<c:url value = "/delete-from-purchase-history?order_id=${order.id}"/>">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
print of list with items will be realised in next version
</body>
</html>
