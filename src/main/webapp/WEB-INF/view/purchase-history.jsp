<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="history" scope="request" type="java.util.List<internetshop.model.Order>"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Purchase history</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    </head>

    <body>
    <div class = "mainContainer" style="font-family: 'Century Gothic' ">
        <div class="col-sm-2"></div>
        <div class="col-sm-8">
            <div class = "row" style="background-color: #c4cfff; min-height: 10%" >
                <div class="col-sm-10">
                    <h1>Purchase history</h1>
                </div>
                <div class="col-sm-2">
                    <a href = "${pageContext.request.contextPath}/index">Index page</a>
                </div>
            </div>

            <div class = "row" style="min-height: 85%">
                <p>Here's your purchase history:</p>
                <table border="1px">
                    <tr>
                        <th>ID</th>
                        <th>Items</th>
                        <th>TotalPrice</th>
                        <th>Remove</th>
                    </tr>
                    <c:forEach var="order" items="${history}">
                        <tr>
                            <td>
                                <c:out value="${order.id}" />
                            </td>
                            <td>
                                <p>Ordered items:</p>
                                <table>
                                    <c:forEach var="item" items="${order.itemsList}">
                                        <tr>
                                            <td>
                                                <c:out value="${item.name}"/> -
                                            </td>
                                            <td>
                                                <c:out value="${item.price}"/> $
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </td>
                            <td>
                                <c:out value="${order.totalPrice}"/> $
                            </td>
                            <td>
                                <a href = "${pageContext.request.contextPath}/delete-from-purchase-history?order_id=${order.id}">remove</a>
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
