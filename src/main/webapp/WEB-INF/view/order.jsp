<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 18-Sep-19
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order</title>
</head>
<body>
    Congratulations! You have ordered a purchase.
    <div>
        <div>
            <a href = "<c:url value = "/index"/>">Return to Index page</a>
        </div>
        <div>
            <a href = "<c:url value = "/purchase-history"/>">View my purchase history</a>
        </div>
    </div>
</body>
</html>
