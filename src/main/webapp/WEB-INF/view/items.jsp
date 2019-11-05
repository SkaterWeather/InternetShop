<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="items" scope="request" type="java.util.List<internetshop.model.Item>"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Items</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    </head>

    <body>
    <div class = "mainContainer" style="font-family: 'Century Gothic' ">
        <div class="col-sm-2"></div>
        <div class="col-sm-8">
            <div class = "row" style="background-color: #c4cfff; min-height: 10%" >
                <div class="col-sm-10">
                    <h1>All items</h1>
                </div>
                <div class="col-sm-2">
                    <a href = "${pageContext.request.contextPath}/index">Index page</a>
                </div>
            </div>

            <div class = "row" style="min-height: 85%">
                <p>Hello, Customer! There are list of items you can buy in my shop:</p>
                <table border="1px">
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Add To Bucket</th>
                    </tr>
                    <c:forEach var="item" items="${items}">
                        <tr>
                            <td>
                                <c:out value="${item.id}"/>
                            </td>
                            <td>
                                <c:out value="${item.name}"/>
                            </td>
                            <td>
                                <c:out value="${item.price}"/> $
                            </td>
                            <td>
                                <a href = "${pageContext.request.contextPath}/add-to-bucket?item_id=${item.id}">add</a>
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

</html>
