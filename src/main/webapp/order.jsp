<%--
  Created by IntelliJ IDEA.
  User: huynhthihuyentrang
  Date: 25/11/2023
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form>
    <table>
        <thead>
        <tr>
            <th>Tên sản phẩm</th>
            <th>Số lượng</th>
            <th>Phân loại</th>
            <th>Đơn giá</th>
            <th>Số tiền</th>
        </tr>
        </thead>
    </table>
    <table>
        <tbody>
        <c:forEach items="${lineItems}" var="lineItem">
            <tr>
                <td>${lineItem.detailProduct.product.name}</td>
                <td>${lineItem.quantity}</td>
                <td>${lineItem.detailProduct.unit}</td>
                <td> ${lineItem.detailProduct.currentPrice}</td>
                <td>${lineItem.getTotal()} </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>
</body>
</html>
