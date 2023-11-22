<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/22/2023
  Time: 2:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<link rel="stylesheet" href="style/cart.css">
<head>
    <title>Giỏ Hàng</title>
</head>
<body>
<h1>Đơn hàng</h1>
<div class="header">
    <table>
        <thead>
        <tr>
            <th>Checkbox</th>
            <th>Tên sản phẩm</th>
            <th>Số lượng</th>
            <th>Phân loại</th>
            <th>Đơn giá</th>
            <th>Số tiền</th>
            <th>Thao tác</th>
        </tr>
        </thead>
    </table>
</div>

<div class="content">
    <table>
        <tbody>
        <c:forEach items="${cart.lineItems}" var="lineItem">
            <tr>
                <td><input type="checkbox" value="${lineItem.id}" name="idLineItem"></td>
                <td>${lineItem.detailProduct.product.name} </td>
                <td>${lineItem.quantity}</td>
                <td>${lineItem.detailProduct.unit}</td>
                <td>
                    <c:if test="${lineItem.detailProduct.sale}">
                        <s>${lineItem.detailProduct.price}</s>
                        ${lineItem.detailProduct.price}
                    </c:if>
                    <c:if test="${!lineItem.detailProduct.sale}">
                        ${lineItem.detailProduct.price}
                    </c:if>
                </td>
                <td>${lineItem.getTotal()} </td>
                <td>
                    <form>
                        <button type="button" onclick="removeLineItem(this)"> xoá</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<lable>Tổng thanh toán</lable>
<form action="" method="post">
    <input type="hidden" name="action" value="checkout">
    <input type="submit" value="Mua Hàng">
</form>
<script src="scripts/script.js"></script>
</body>
</html>
